package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.dto.requestDto.AssignRFIDRequest;
import com.mepsanakademi.mepsan.dto.requestDto.PurchaseRequest;
import com.mepsanakademi.mepsan.dto.requestDto.UserRequestDTO;
import com.mepsanakademi.mepsan.dto.responseDto.AdminAllData;
import com.mepsanakademi.mepsan.dto.responseDto.AdminData;
import com.mepsanakademi.mepsan.model.Machine;
import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import com.mepsanakademi.mepsan.model.Store;
import com.mepsanakademi.mepsan.model.User;
import com.mepsanakademi.mepsan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends GenericService<User> {
    private final UserRepository userRepository;
    private final StoreService storeService;
    private final MachineService machineService;

    @Autowired
    public UserService(UserRepository userRepository, StoreService storeService, MachineService machineService) {
        super(userRepository);
        this.userRepository = userRepository;
        this.storeService = storeService;
        this.machineService = machineService;
    }

    public HttpStatus create(UserRequestDTO requestBody) throws Exception {
        if (requestBody.getName() == null || requestBody.getEmail() == null || requestBody.getPhoneNumber() == null) {
            throw new Exception("Name, email and phone number are required fields");
        }
        User user = new User();
        user.setName(requestBody.getName());
        user.setEmail(requestBody.getEmail());
        user.setPhoneNumber(requestBody.getPhoneNumber());
        return HttpStatus.CREATED;
    }

    public HttpStatus assignRFID(AssignRFIDRequest request) {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null) {
            return HttpStatus.BAD_REQUEST;
        }
        user.setRfidCardUID(request.getCardUID());
        userRepository.save(user);
        return HttpStatus.OK;
    }

    public boolean controlUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null;
    }

    public double getBalance(String userId) throws Exception {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new Exception("User not found for id: " + userId);
        }
        return user.getBalance();
    }

    public boolean controlAdminUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        List<Store> stores = storeService.findByAdminId(userId);
        return !stores.isEmpty();
    }

    public AdminAllData getAllData(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        AdminAllData adminAllData = new AdminAllData();

        List<Store> stores = storeService.findByAdminId(userId);
        adminAllData.setStore(stores);

        List<Machine> machines = machineService.findByStoreIds(stores.stream().map(Store::getId).toList());
        adminAllData.setMachine(machines);

        List<RecyclingTransaction> transactions = machineService.getTransactionsByMachineIds(machines.stream().map(Machine::getId).toList());
        adminAllData.setRecyclingTransactions(transactions);

        return adminAllData;
    }

    public AdminData getMachineDataDaily(String userId, String machineId) throws Exception {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }

        AdminData adminData = new AdminData();

        Store store = storeService.findByMachineId(machineId);
        if (store == null || !store.getId().equals(userId)) {
            throw new Exception("Store not found for machine id: " + machineId);
        }
        adminData.setStore(store);

        Machine machine = machineService.findByStoreId(store.getId());
        adminData.setMachine(machine);

        List<RecyclingTransaction> transactions = machineService.getTodayTransactionsByMachineId(machine.getId());
        adminData.setRecyclingTransactions(transactions);

        return adminData;
    }

    public HttpStatus purchase(PurchaseRequest purchaseRequest) throws Exception {
        User user = userRepository.findById(purchaseRequest.getUserId()).orElse(null);
        if (user == null) {
            throw new Exception("User not found for id: " + purchaseRequest.getUserId());
        }
        if (user.getBalance() < purchaseRequest.getAmount()) {
            throw new Exception("Insufficient balance");
        }
        user.setBalance(user.getBalance() - purchaseRequest.getAmount());
        userRepository.save(user);
        return HttpStatus.OK;
    }
}

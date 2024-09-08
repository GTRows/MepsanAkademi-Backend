package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.dto.requestDto.RecyclingItemsRequest;
import com.mepsanakademi.mepsan.model.Machine;
import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import com.mepsanakademi.mepsan.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService extends GenericService<Machine>{
    private final MachineRepository machineRepository;
    private final RecyclingService recyclingService;

    @Autowired
    public MachineService(MachineRepository machineRepository, RecyclingService recyclingService) {
        super(machineRepository);
        this.machineRepository = machineRepository;
        this.recyclingService = recyclingService;
    }

    public HttpStatus recyclingItems(RecyclingItemsRequest request) throws Exception {
        return recyclingService.recyclingItems(request);
    }

    public List<Machine> findByStoreIds(List<String> list) {
        return machineRepository.findAllByStoreIdIn(list);
    }

    public List<RecyclingTransaction> getTransactionsByMachineIds(List<String> list) {
        return recyclingService.getTransactionsByMachineIds(list);
    }

    public Machine findByStoreId(String id) {
        return machineRepository.findByStoreId(id);
    }

    public List<RecyclingTransaction> getTodayTransactionsByMachineId(String id) {
        // get only today's transactions
        return recyclingService.getTodayTransactionsByMachineId(id);
    }
}

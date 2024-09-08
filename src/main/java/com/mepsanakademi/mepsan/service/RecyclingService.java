package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.dto.requestDto.RecyclingItemsRequest;
import com.mepsanakademi.mepsan.model.RecyclingMaterial;
import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import com.mepsanakademi.mepsan.repository.RecyclingTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RecyclingService extends GenericService<RecyclingTransaction> {
    private final RecyclingTransactionRepository recyclingTransactionRepository;
    private final MaterialService materialService;

    @Autowired
    public RecyclingService(RecyclingTransactionRepository recyclingTransactionRepository, MaterialService materialService) {
        super(recyclingTransactionRepository);
        this.recyclingTransactionRepository = recyclingTransactionRepository;
        this.materialService = materialService;
    }

    public HttpStatus recyclingItems(RecyclingItemsRequest request) throws Exception {
        RecyclingTransaction recyclingTransaction = new RecyclingTransaction();
        recyclingTransaction.setMachineId(request.getMachineId());
        recyclingTransaction.setTransactionDate(request.getTransactionDate());
        recyclingTransaction.setMaterials(request.getMaterials());
        for (RecyclingMaterial material : request.getMaterials()) {
            if(material.getReward() != materialService.GetMaterialBalance(material.getMaterialId())){
                throw new Exception("Material reward is not correct for material id: " + material.getMaterialId());
            }
        }
        recyclingTransactionRepository.save(recyclingTransaction);
        return HttpStatus.OK;
    }

    public List<RecyclingTransaction> getTransactionsByMachineIds(List<String> list) {
        return recyclingTransactionRepository.findAllByMachineIdIn(list);
    }

    public List<RecyclingTransaction> getTodayTransactionsByMachineId(String machineId) {
        // Get the start and end of the current day
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        // Fetch today's transactions by machine ID
        return recyclingTransactionRepository.findAllByMachineIdAndTransactionDateBetween(machineId, startOfDay, endOfDay);
    }
}

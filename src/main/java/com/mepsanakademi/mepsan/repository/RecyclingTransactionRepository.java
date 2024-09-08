package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RecyclingTransactionRepository extends MongoRepository<RecyclingTransaction, String> {
    @Query("{ 'machineId' : { $in: ?0 } }")
    List<RecyclingTransaction> findAllByMachineIdIn(List<String> list);

    List<RecyclingTransaction> findAllByMachineIdAndTransactionDateBetween(
            String machineId, LocalDateTime startOfDay, LocalDateTime endOfDay);
}

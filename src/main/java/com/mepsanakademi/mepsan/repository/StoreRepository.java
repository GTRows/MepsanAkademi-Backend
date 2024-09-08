package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String> {

    @Query("{ 'managerId' : ?0 }")
    List<Store> findAllByManagerId(String managerId);

    @Query("{ 'machineId' : ?0 }")
    Store findByMachineId(String machineId);
}

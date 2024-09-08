package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MachineRepository extends MongoRepository<Machine, String> {
    @Query("{ 'storeId' : { $in: ?0 } }")
    List<Machine> findAllByStoreIdIn(List<String> list);

    @Query("{ 'storeId' : ?0 }")
    Machine findByStoreId(String id);
}

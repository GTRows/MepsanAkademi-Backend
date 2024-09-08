package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MachineRepository extends MongoRepository<Machine, String> {
}

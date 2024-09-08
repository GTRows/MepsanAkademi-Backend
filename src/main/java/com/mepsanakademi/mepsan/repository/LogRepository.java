package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
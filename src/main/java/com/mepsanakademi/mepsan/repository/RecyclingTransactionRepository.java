package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.RecyclingTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecyclingTransactionRepository extends MongoRepository<RecyclingTransaction, String> {
}

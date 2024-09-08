package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {
}

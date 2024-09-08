package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.Material;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRepository extends MongoRepository<Material, String> {
}

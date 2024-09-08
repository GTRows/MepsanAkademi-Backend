package com.mepsanakademi.mepsan.repository;

import com.mepsanakademi.mepsan.model.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RewardRepository extends MongoRepository<Reward, String> {
}

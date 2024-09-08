package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.model.Reward;
import com.mepsanakademi.mepsan.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService extends GenericService<Reward> {
    private final RewardRepository rewardRepository;

    @Autowired
    public RewardService(RewardRepository rewardRepository) {
        super(rewardRepository);
        this.rewardRepository = rewardRepository;
    }
}

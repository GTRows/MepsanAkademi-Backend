package com.mepsanakademi.mepsan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private final RecyclingService recyclingService;

    @Autowired
    public RewardService(RecyclingService recyclingService) {
        this.recyclingService = recyclingService;
    }
}

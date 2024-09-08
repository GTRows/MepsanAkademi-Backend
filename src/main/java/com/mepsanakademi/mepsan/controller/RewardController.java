package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.model.Reward;
import com.mepsanakademi.mepsan.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reward")
public class RewardController extends GenericController<Reward> {
    private final RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService) {
        super(rewardService);
        this.rewardService = rewardService;
    }
}

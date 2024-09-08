package com.mepsanakademi.mepsan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecyclingService {
    private final MachineService machineService;

    @Autowired
    public RecyclingService(MachineService machineService) {
        this.machineService = machineService;
    }
}

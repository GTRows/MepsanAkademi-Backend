package com.mepsanakademi.mepsan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final MachineService machineService;

    @Autowired
    public UserService(MachineService machineService) {
        this.machineService = machineService;
    }
}

package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.model.Machine;
import com.mepsanakademi.mepsan.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService extends GenericService<Machine>{
    private final MachineRepository machineRepository;

    @Autowired
    public MachineService(MachineRepository machineRepository) {
        super(machineRepository);
        this.machineRepository = machineRepository;
    }
}

package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.model.Machine;
import com.mepsanakademi.mepsan.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machine")
public class MachineController extends GenericController<Machine> {

    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService){
        super(machineService);
        this.machineService = machineService;
    }

}

package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.dto.requestDto.RecyclingItemsRequest;
import com.mepsanakademi.mepsan.model.Machine;
import com.mepsanakademi.mepsan.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/recycling-items")
    public ResponseEntity<?> recyclingItems(@RequestBody RecyclingItemsRequest request){
        try {
            HttpStatus response = machineService.recyclingItems(request);
            return ResponseEntity.status(response).body("Items recycled successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

package com.mepsanakademi.mepsan.controller;

import com.mepsanakademi.mepsan.dto.requestDto.AssignRFIDRequest;
import com.mepsanakademi.mepsan.dto.requestDto.PurchaseRequest;
import com.mepsanakademi.mepsan.dto.requestDto.UserRequestDTO;
import com.mepsanakademi.mepsan.model.User;
import com.mepsanakademi.mepsan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User> {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody UserRequestDTO requestBody) {
        try {
            HttpStatus response = userService.create(requestBody);
            if (response == HttpStatus.CREATED) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User created successfully");
            }
            return ResponseEntity.status(response).body("User could not be created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/assign-rfid")
    public ResponseEntity<?> assignRFID(@RequestBody AssignRFIDRequest request) {
        if (userService.controlUser(request.getUserId())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing authentication");
        }
        try {
            HttpStatus response = userService.assignRFID(request);
            return ResponseEntity.status(response).body("RFID assigned successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{userId}/get-balance")
    public ResponseEntity<?> getBalance(@PathVariable String userId) {
        if (userService.controlUser(userId)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing authentication");
        }
        try {
            return ResponseEntity.ok(userService.getBalance(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/admin/{userId}/get-all-data")
    public ResponseEntity<?> getAllData(@PathVariable String userId) {
        if (userService.controlAdminUser(userId)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing authentication");
        }
        try {
            return ResponseEntity.ok(userService.getAllData(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/admin/{userId}/get-machine-data-daily/{machineId}")
    public ResponseEntity<?> getMachineDataDaily(@PathVariable String userId, @PathVariable String machineId) {
        if (userService.controlAdminUser(userId)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing authentication");
        }
        try {
            return ResponseEntity.ok(userService.getMachineDataDaily(userId, machineId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody PurchaseRequest request) {
        try {
            if (HttpStatus.OK == userService.purchase(request)) {
                return ResponseEntity.ok().body("Purchase successful");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Purchase failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

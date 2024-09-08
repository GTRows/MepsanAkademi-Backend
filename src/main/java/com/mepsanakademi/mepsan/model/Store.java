package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "stores")
@Getter
@Setter
public class Store extends BaseEntity{
    private String name;
    private String location;
    private String managerId;
    private LocalDateTime createdAt;
    private List<String> machinesId;

    public Store(String name, String location, String managerId, List<String> machinesId){
        this.name = name;
        this.location = location;
        this.managerId = managerId;
        this.machinesId = machinesId;
        this.createdAt = LocalDateTime.now();
    }

    public Store(String name, String location, String managerId){
        this.name = name;
        this.location = location;
        this.managerId = managerId;
        this.machinesId = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
    }
}

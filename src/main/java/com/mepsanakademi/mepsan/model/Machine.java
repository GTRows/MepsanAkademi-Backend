package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "machines")
@Getter
@Setter
public class Machine extends BaseEntity {
    private String serialNumber;
    private String status;
    private String storeId;
    private LocalDateTime installationDate;

    public Machine(String serialNumber, String status, String storeId){
        this.serialNumber = serialNumber;
        this.status = status;
        this.storeId = storeId;
        this.installationDate = LocalDateTime.now();
    }
}

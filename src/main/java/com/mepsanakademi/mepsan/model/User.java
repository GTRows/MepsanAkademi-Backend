package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
public class User extends BaseEntity{
    private String name;
    private int rfidCardUID;
    private BigDecimal balance;
    private LocalDateTime createdAt;
}


package com.mepsanakademi.mepsan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "rewards")
@Getter
@Setter
public class Reward extends BaseEntity{
    private String userId;
    private BigDecimal totalReward;
    private BigDecimal remainingBalance;
    private LocalDateTime lastUpdated;

    public Reward(String userId, BigDecimal totalReward, BigDecimal remainingBalance){
        this.userId = userId;
        this.totalReward = totalReward;
        this.remainingBalance = remainingBalance;
        this.lastUpdated = LocalDateTime.now();
    }
}


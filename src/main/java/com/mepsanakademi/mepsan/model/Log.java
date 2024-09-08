package com.mepsanakademi.mepsan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs")
@Getter
@Setter
public class Log extends BaseEntity{
    private String level;
    private String message;
    private String className;
    private String methodName;
    private LocalDateTime timestamp;
}

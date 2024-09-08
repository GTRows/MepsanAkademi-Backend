package com.mepsanakademi.mepsan.service;

import com.mepsanakademi.mepsan.model.Log;
import com.mepsanakademi.mepsan.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggingService {
    @Autowired
    private LogRepository logRepository;

    public void log(String level, String message, String className, String methodName) {
        Log log = new Log();
        log.setLevel(level);
        log.setMessage(message);
        log.setClassName(className);
        log.setMethodName(methodName);
        log.setTimestamp(LocalDateTime.now());
        logRepository.save(log);
    }
}

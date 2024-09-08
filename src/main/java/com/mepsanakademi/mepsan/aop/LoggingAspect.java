package com.mepsanakademi.mepsan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import com.mepsanakademi.mepsan.service.LoggingService;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private LoggingService loggingService;

    @Before("execution((* com.mepsanakademi..*(..)))")
    public void logBefore(JoinPoint joinPoint) {
        loggingService.log("INFO", "Method called: " + joinPoint.getSignature().getName(),
                            joinPoint.getSignature().getDeclaringTypeName(),
                            joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.mepsanakademi..*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        loggingService.log("ERROR", "Exception in method: " + joinPoint.getSignature().getName() + " with message: " + exception.getMessage(),
                            joinPoint.getSignature().getDeclaringTypeName(),
                            joinPoint.getSignature().getName());
    }
}


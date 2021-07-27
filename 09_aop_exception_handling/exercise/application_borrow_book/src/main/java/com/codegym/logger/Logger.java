package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* com.codegym.model.service.BookService.save(..))")
    public void addPointCut(){
    }

    @After("addPointCut()")
    public void logAfterCallMethod() {
        System.err.println("After the book status changed");
    }

    @Pointcut("within(com.codegym.controller.BookController*)")
    public void countActivities(){
    }

    @After("countActivities()")
    public void logAfterActions(JoinPoint joinPoint) {
        System.err.println("After method name: " + joinPoint.getSignature().getName() +
                           " - Time: " + LocalDateTime.now());
    }
}

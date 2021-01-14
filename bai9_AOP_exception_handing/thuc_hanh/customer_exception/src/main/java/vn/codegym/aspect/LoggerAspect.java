package vn.codegym.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* vn.codegym.controller.CustomerController.*listCustomers(..))")
    public void customerControllerMethod(){}
    //
    @Before("customerControllerMethod()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
    }
    //
    @After("customerControllerMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("End method name: " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
    }
}

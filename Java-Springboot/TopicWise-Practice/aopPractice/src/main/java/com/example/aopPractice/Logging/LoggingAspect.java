package com.example.aopPractice.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;


@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.aopPractice.Controller.Employee.fetchEmployeeData(..))")
    public void beforeFetchEmployeeDataMethod(){
        System.out.println("Logging calling before fetchEmployeeData() execution");
    }

    @Before("execution(* com.example.aopPractice..fetchEmployeeData(..))")
    public void beforeFetchEmployeeDataMethodAnyPackage(){
        System.out.println("Logging calling in any package before fetchEmployeeData() execution");
    }

    @After("execution(* com.example.aopPractice..*(..))")
    public void afterFetchAnyMethodAnyPackage(){
        System.out.println("Logging calling in any package after any() execution");
    }

    @Before("within(com.example.aopPractice.Controller.Employee)")
    public void beforeFetchAnyMethodInCalss(){
        System.out.println("Logging calling in Employee Class before any() execution");
    }

    @Before("within(com.example.aopPractice.Controller..*)")
    public void beforeFetchAnyCalss(JoinPoint joinPoint){
        System.out.println("Logging calling in any Class before "+joinPoint.getSignature().getName()+"()");
    }

    // @annotation : that matches any method that is annotated with given annotation
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeGetCall(){
        System.out.println("Logging calling in any Class before GET execution");
    }

    // Args : matches any method with particular arguments
//    @Before("args(int)")
//    public void beforeAnyMethodWithMentionedArgs(){
//        System.out.println("Logging calling  before method with args(int)");
//    }

    // @args : matches any method with particular parameters and that parameter class is annoted with particular annotation


    // Custom Pointcut name
    @Pointcut("within(com.example.aopPractice.Controller.Employee)")
    public void customPointCutAnyClassInEmployee(){}

    @Before("customPointCutAnyClassInEmployee()")
    public void AnyClassInEmployee(){
        System.out.println("Logging calling in Employee Class before any() execution using custom pointcut");
    }
}

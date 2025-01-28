package com.example.aopPractice.Serivice;

import org.springframework.stereotype.Service;

@Service
public class EmployeeUtil {
    public void employeeHelperUtil(int any){
        System.out.println("employeeHelperUtil() called");
    }
}

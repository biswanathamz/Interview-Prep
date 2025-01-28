package com.example.aopPractice.Controller;
import com.example.aopPractice.Serivice.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class Employee {

    @Autowired
    EmployeeUtil employeeUtil;

    @GetMapping(path = "/fetchEmployeeData")
    public String fetchEmployeeData(){
        employeeUtil.employeeHelperUtil(123);
        return "Data Fetched";
    }
}

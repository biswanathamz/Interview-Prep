package com.affninf.projectManagement.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    public String name;
    public  String description;
    public User assignedTo;
    public Date createdAt;
    public Date modifiedAt;
}

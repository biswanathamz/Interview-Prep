package com.affninf.projectManagement.Dto;

import com.affninf.projectManagement.Enum.Roles;
import lombok.Data;

@Data
public class User {
    public String firstName;
    public String lastName;
    public Roles role;
}

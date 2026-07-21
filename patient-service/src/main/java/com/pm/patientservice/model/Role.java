package com.pm.patientservice.model;

public enum Role {
    ADMIN ("admin",1),
    MANAGER("manager",2),
    EMPLOYEE("employee",3);

    final String description;
    final int level;

    Role(String description, int level)
    {
        this.description = description;
        this.level = level;;
    }
}

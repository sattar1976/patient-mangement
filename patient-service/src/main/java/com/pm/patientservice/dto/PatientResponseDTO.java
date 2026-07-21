package com.pm.patientservice.dto;

import java.util.UUID;

public class PatientResponseDTO {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String dateOfBirth;

    private String email;

    private String address;

    private String name;

    private String iD;

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    private String registeredDate;

    public void setID(String id) {
     this.iD=id;
    }
    public String getID( ) {
       return iD;
    }

}

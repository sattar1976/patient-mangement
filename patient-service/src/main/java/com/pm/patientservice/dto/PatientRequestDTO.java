package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validation.AgeValidatorType;
import com.pm.patientservice.dto.validation.NewPatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

//import jakarta.validation.constraints.
public class PatientRequestDTO {

    @NotNull (message = "missing the Date of Birth")
    @AgeValidatorType
    private String dateOfBirth;
    @Email(message = "Email address is not valid")
    @NotNull
    @NotBlank (message = "Email adddress can not be blank")
    private String email;

    @NotBlank (message = "Message can not be blank")
    private String address;

    @NotBlank (message = "name can not be blank")
     private String name;


    @NotBlank(groups = NewPatientValidationGroup.class, message = "Must have registered Date")
    private String registeredDate;









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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }



    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

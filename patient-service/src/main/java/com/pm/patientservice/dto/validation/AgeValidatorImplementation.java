package com.pm.patientservice.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidatorImplementation implements ConstraintValidator <AgeValidatorType,String> {

    @Override
    public boolean isValid(String providedDate, ConstraintValidatorContext context)
    {
        if (providedDate == null) {
            return false;
        }
        LocalDate date = LocalDate.parse(providedDate);
        return Period.between(date, LocalDate.now()).getYears() >= 18;
    }
}

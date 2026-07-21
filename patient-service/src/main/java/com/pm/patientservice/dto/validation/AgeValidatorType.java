package com.pm.patientservice.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeValidatorImplementation.class)

public @interface AgeValidatorType {

    public String message () default "Age must be more than 18 years";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

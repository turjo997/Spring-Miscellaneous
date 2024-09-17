package com.spring.entity_data_validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD , ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface ValidatorEmployeeType {

    public String message () default "Invalid employeeType: It should be either Permanent Or vendor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

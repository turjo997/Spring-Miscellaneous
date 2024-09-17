package com.spring.entity_data_validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class EmployeeTypeValidator implements ConstraintValidator<ValidatorEmployeeType , String> {


    @Override
    public boolean isValid(String employeeType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> employeeTypes = Arrays.asList("Permanent", "vendor");
        return employeeTypes.contains(employeeType);
    }
}

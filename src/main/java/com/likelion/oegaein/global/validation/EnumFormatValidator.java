package com.likelion.oegaein.global.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumFormatValidator implements ConstraintValidator<EnumFormat, Enum> {
    private List<Object> enumValues;
    @Override
    public void initialize(EnumFormat constraintAnnotation) {
        enumValues = getEnumValues(constraintAnnotation);
    }

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {
        return isNotNull(value) && isContainsValue(value);
    }

    private List<Object> getEnumValues(EnumFormat constraintAnnotation){
        Class<? extends Enum> enumClass = constraintAnnotation.enumClass();
        return Arrays.stream(enumClass.getEnumConstants()).collect(Collectors.toList());
    }

    private boolean isContainsValue(Enum value){
        return enumValues.contains(value);
    }

    private boolean isNotNull(Enum value){
        return value != null;
    }
}

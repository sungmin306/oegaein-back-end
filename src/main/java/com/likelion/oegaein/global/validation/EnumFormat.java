package com.likelion.oegaein.global.validation;

import com.likelion.oegaein.domain.matching.entity.DongType;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumFormatValidator.class)
public @interface EnumFormat {
    String message() default "해당 필드의 타입에서 지원하지 않는 값입니다.";
    Class[] groups() default {};
    Class[] payload() default {};
    Class<? extends Enum> enumClass();
}
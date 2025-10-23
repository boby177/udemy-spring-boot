package com.bob.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // Define default course code
    public String value() default "B0B";

    // Define default error message
    public String message() default "Must start with B0B";

    // Define default groups
    public Class<?>[] groups() default {};

    // Define default payloads
    public Class <? extends Payload>[] payload() default {};

}

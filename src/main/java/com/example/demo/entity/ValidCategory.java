package com.example.demo.entity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CategoryValidator.class})
public @interface ValidCategory {
  String param() default "";
  String message() default "category entity validation error on '{wrongValue}'";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

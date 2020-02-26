package com.example.demo.entity;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<ValidCategory, Category> {

  String param;

  @Override
  public void initialize(ValidCategory constraintAnnotation) {
    this.param = constraintAnnotation.param();
    System.out.println("@initialize : param=" + param + ", hashCode=" + hashCode());
  }

  @Override
  public boolean isValid(Category entity, ConstraintValidatorContext context) {
    System.out.println("@isValid : param=" + param + ", hashCode=" + hashCode() + ", entity=" + entity);
    String wrongValue = null;
    if (entity.getName() == null || entity.getCreateAt() == null || entity.getUpdateAt() == null) {
      wrongValue = "field null";
    } else if (entity.getCreateAt().isAfter(entity.getUpdateAt())) {
      wrongValue = "createAt";
    }
    if (wrongValue != null) {
      ((ConstraintValidatorContextImpl)context).addMessageParameter("wrongValue", wrongValue);
      return false;
    }
    return true;
  }
}

package com.example.demo.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CategoryValidatorTests {

  @Autowired
  private Validator validator;

  @Test
  public void anyFieldNull() {
    Category category = new Category();
    Set<ConstraintViolation<Object>> violations = validator.validate(category);
    assertThat(violations.isEmpty()).isFalse();
    assertThat(violations).hasSize(3);
    assertThat(violations)
        .extracting("message")
        .contains("must not be null",
                  "must not be null",
                  "category entity validation error on 'field null'");
  }

  @Test
  public void createAtIsFuture() {
    Category category = new Category();
    category.setName("test category");
    category.setCreateAt(LocalDateTime.now().plus(1, ChronoUnit.MINUTES));
    category.setUpdateAt(LocalDateTime.now());
    Set<ConstraintViolation<Object>> violations = validator.validate(category);
    assertThat(violations.isEmpty()).isFalse();
    assertThat(violations).hasSize(1);
    assertThat(violations)
        .extracting("message")
        .contains("category entity validation error on 'createAt'");
  }

}

package com.example.demo.entity;

import com.example.demo.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class CategoryTests {
  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void nameMustNotBeNull() {
    Category category = new Category();
    category.setName(null);
    category.setCreateAt(LocalDateTime.now());
    category.setUpdateAt(LocalDateTime.now());

    assertThatThrownBy(() -> {
      Category actual = categoryRepository.saveAndFlush(category);
      System.out.println(actual);
    })
    .isInstanceOf(ConstraintViolationException.class)
    .hasMessageContaining("category entity validation error on 'field null'");
  }

  @Test
  public void createAtMustNotBeFuture() {
    Category category = new Category();
    category.setName("test category");
    category.setCreateAt(LocalDateTime.now().plus(1, ChronoUnit.MINUTES));
    category.setUpdateAt(LocalDateTime.now());

    assertThatThrownBy(() -> {
      Category actual = categoryRepository.saveAndFlush(category);
      System.out.println(actual);
    })
    .isInstanceOf(ConstraintViolationException.class)
    .hasMessageContaining("category entity validation error on 'createAt'");
  }

}

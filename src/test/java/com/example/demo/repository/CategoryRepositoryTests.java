package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CategoryRepositoryTests {
  @Autowired
  private CategoryRepository categoryRepository;

  @BeforeEach
  public void setup() {
    System.out.println("setup");
  }

  @Test
  public void findById() {
    Optional<Category> categoryOptional = categoryRepository.findById(1L);
    assertThat(categoryOptional.isPresent()).isTrue();
    Category actual = categoryOptional.get();
    assertThat(actual.getId()).isEqualTo(1L);
  }

  @Test
  public void findAll() {
    List<Category> actual = categoryRepository.findAll();
    assertThat(actual).hasSize(30);
  }
}

package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemStock;
import com.example.demo.type.ModelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ItemRepositoryTests {
  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private CategoryRepository categoryRepository;

  @BeforeEach
  public void setup() {
    System.out.println("setup");
  }

  @Test
  public void findById() {
    Optional<Item> itemOptional = itemRepository.findById(1L);
    assertThat(itemOptional.isPresent()).isTrue();
    Item item = itemOptional.get();
    assertThat(item)
        .extracting("id", "name", "price", "salesFrom", "salesTo", "modelType")
        .contains(1L, "item_01_1", 100, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31), ModelType.A);
  }

  @Test
  public void save() {
    Optional<Category> categoryOptional = categoryRepository.findById(1L);
    Category category = categoryOptional.get();
    List<ItemStock> itemStocks = List.of();
    Item item = new Item(null, category, "item", 1000, LocalDate.now(), LocalDate.now(), ModelType.A, LocalDateTime.now(), LocalDateTime.now(), itemStocks);
    Item actual = itemRepository.save(item);
    assertThat(actual.getId()).isNotNull();
    System.out.println(actual);
  }

}

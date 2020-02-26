package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
  private final ItemRepository itemRepository;
  private final CategoryRepository categoryRepository;

  public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository) {
    this.itemRepository = itemRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public List<Item> findByCategory(Long categoryId) {
    Category category = findCategoryById(categoryId);
    return itemRepository.findByCategory(category);
  }

  private Category findCategoryById(Long id) {
    return categoryRepository.getOne(id);
  }

}

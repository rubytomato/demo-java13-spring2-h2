package com.example.demo.service;

import com.example.demo.entity.Item;

import java.util.List;

public interface ItemService {
  List<Item> findByCategory(Long categoryId);
}

package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
  Optional<User> findById(Long id);
  Optional<User> findByEmail(String email);
  List<User> findAll(Pageable page);
}

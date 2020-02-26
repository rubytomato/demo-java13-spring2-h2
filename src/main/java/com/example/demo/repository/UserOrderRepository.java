package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
  List<UserOrder> findByUser(User user);
}

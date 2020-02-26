package com.example.demo.repository;

import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.entity.UserOrder;
import com.example.demo.entity.UserOrderItem;
import com.example.demo.type.OrderType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserOrderRepositoryTests {
  @Autowired
  private UserOrderRepository userOrderRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void findByUser() {
    Optional<User> userOptional = userRepository.findById(2L);
    User user = userOptional.get();
    List<UserOrder> userOrders = userOrderRepository.findByUser(user);
    assertThat(userOrders).hasSize(1);
    userOrders.forEach(order -> {
      assertThat(order.getUserOrderItems()).hasSize(1);
      assertThat(order.getUserOrderReview()).isNull();
    });
  }

  @Test
  public void findByUser_2() {
    Optional<User> userOptional = userRepository.findById(3L);
    User user = userOptional.get();
    List<UserOrder> userOrders = userOrderRepository.findByUser(user);
    assertThat(userOrders).hasSize(1);
    userOrders.forEach(order -> {
      assertThat(order.getUserOrderItems()).hasSize(3);
      assertThat(order.getUserOrderReview()).isNotNull();
    });
  }

  @Test
  public void save() {
    Optional<User> userOptional = userRepository.findById(1L);
    User user = userOptional.get();

    UserOrder userOrder = new UserOrder();
    userOrder.setUser(user);
    userOrder.setOrderAt(LocalDateTime.now());
    userOrder.setOrderType(OrderType.ONLINE);
    userOrder.setCancelFlag(Boolean.FALSE);
    userOrder.addOrderItem(getOrderItem(1L, 1));
    userOrder.addOrderItem(getOrderItem(2L, 2));

    UserOrder actual = userOrderRepository.saveAndFlush(userOrder);
    assertThat(actual).isNotNull();
    assertThat(actual.getId()).isNotNull();
    System.out.println(actual);
  }

  private UserOrderItem getOrderItem(Long id, Integer amount) {
    Item item = itemRepository.getOne(id);
    UserOrderItem userOrderItem = new UserOrderItem();
    userOrderItem.setItem(item);
    userOrderItem.setPrice(item.getPrice());
    userOrderItem.setAmount(amount);
    return userOrderItem;
  }

}

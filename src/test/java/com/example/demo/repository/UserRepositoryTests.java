package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.type.GenderType;
import com.example.demo.type.PrefectureType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTests {
  @Autowired
  private UserRepository userRepository;

  @BeforeEach
  public void setup() {
    System.out.println("setup");
  }

  @Test
  public void findById() {
    Optional<User> userOptional = userRepository.findById(1L);
    assertThat(userOptional.isPresent()).isTrue();
    User user = userOptional.get();
    System.out.println(user);
  }

  @Test
  public void save() {
    User user = new User();
    user.setName("user_08");
    user.setEmail("user_08@example.com");
    user.setGenderType(GenderType.M);
    user.setPrefectureType(PrefectureType.TOKYO);

    User actual = userRepository.saveAndFlush(user);
    assertThat(actual).isNotNull();
    System.out.println(actual);
  }
}

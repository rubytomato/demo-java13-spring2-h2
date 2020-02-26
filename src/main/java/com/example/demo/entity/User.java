package com.example.demo.entity;

import com.example.demo.type.GenderType;
import com.example.demo.type.PrefectureType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user")
  @SequenceGenerator(name = "seq_user", sequenceName = "seq_user_id", allocationSize = 25)
  private Long id;
  @Column(name = "name", length = 60, nullable = false)
  private String name;
  @Column(name = "gender_type")
  private GenderType genderType;
  @Column(name = "prefecture_type", nullable = false)
  private PrefectureType prefectureType;
  @Column(name = "email", length = 90, nullable = false, unique = true)
  private String email;
  @Column(name = "create_at", nullable = false)
  @JsonIgnore
  private LocalDateTime createAt;
  @Column(name = "update_at", nullable = false)
  @JsonIgnore
  private LocalDateTime updateAt;

  @PrePersist
  public void prePersist() {
    createAt = LocalDateTime.now();
    updateAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updateAt = LocalDateTime.now();
  }

}

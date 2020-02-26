package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Table(name = "category")
@Entity
@ValidCategory(param = "test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_category")
  @SequenceGenerator(name = "seq_category", sequenceName = "seq_category_id", allocationSize = 25)
  private Long id;
  @Size(min = 1, max = 60)
  @Column(name = "name", length = 60, nullable = false)
  private String name;
  @NotNull
  @Column(name = "create_at", nullable = false)
  @JsonIgnore
  private LocalDateTime createAt;
  @NotNull
  @Column(name = "update_at", nullable = false)
  @JsonIgnore
  private LocalDateTime updateAt;

  @PrePersist
  public void prePersist() {
    if (createAt == null) {
      createAt = LocalDateTime.now();
    }
    if (updateAt == null) {
      updateAt = LocalDateTime.now();
    }
  }

  @PreUpdate
  public void preUpdate() {
    updateAt = LocalDateTime.now();
  }

}

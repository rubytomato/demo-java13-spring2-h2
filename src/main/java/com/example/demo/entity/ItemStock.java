package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "item_stock")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemStock {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_item_stock")
  @SequenceGenerator(name = "seq_item_stock", sequenceName = "seq_item_stock_id", allocationSize = 25)
  private Long id;
  @Column(name = "stock", columnDefinition = "INT NOT NULL DEFAULT 0")
  private Integer stock;
  @Column(name = "available_from", nullable = false)
  private LocalDate availableFrom;
  @Column(name = "availableTo")
  private LocalDate availableTo;
  @ManyToOne
  @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_item_stock__item_id__item__id"), nullable = false)
  private Item item;
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

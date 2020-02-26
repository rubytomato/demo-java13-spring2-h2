package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
import java.time.LocalDateTime;

@Table(name = "user_order_item")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userOrder"})
public class UserOrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user_order_item")
  @SequenceGenerator(name = "seq_user_order_item", sequenceName = "seq_user_order_item_id", allocationSize = 25)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "user_order_id", foreignKey = @ForeignKey(name = "fk_user_order_item__user_order_id__user_order__id"), nullable = false)
  private UserOrder userOrder;
  @ManyToOne
  @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_user_order_item__item_id__item__id"), nullable = false)
  private Item item;
  @Column(name = "price", nullable = false)
  private Integer price;
  @Column(name = "amount", nullable = false)
  private Integer amount;
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

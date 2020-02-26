package com.example.demo.entity;

import com.example.demo.type.OrderType;
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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "user_order", indexes = { @Index(name = "user_order_idx1", columnList = "user_id, order_at, shipped_at") })
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userOrderItems"})
public class UserOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user_order")
  @SequenceGenerator(name = "seq_user_order", sequenceName = "seq_user_order_id", allocationSize = 25)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_order__user_id__user__id"))
  private User user;
  @Column(name = "order_at", nullable = false)
  private LocalDateTime orderAt;
  @Column(name = "order_type", nullable = false)
  private OrderType orderType;
  @Column(name = "shipped_at")
  private LocalDateTime shippedAt;
  @Column(name = "cancel_flag", nullable = false)
  private Boolean cancelFlag;
  @Column(name = "create_at", nullable = false)
  @JsonIgnore
  private LocalDateTime createAt;
  @Column(name = "update_at", nullable = false)
  @JsonIgnore
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "userOrder", cascade = CascadeType.ALL)
  private List<UserOrderItem> userOrderItems;

  @OneToOne(mappedBy = "userOrder", cascade = CascadeType.ALL)
  private UserOrderReview userOrderReview;

  public void addOrderItem(UserOrderItem orderItem) {
    if (userOrderItems == null) {
      userOrderItems = new ArrayList<>();
    }
    if (!userOrderItems.contains(orderItem)) {
      userOrderItems.add(orderItem);
      orderItem.setUserOrder(this);
    }
  }

  public void addOrderReview(UserOrderReview orderReview) {
    userOrderReview = orderReview;
    orderReview.setUserOrder(this);
  }

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

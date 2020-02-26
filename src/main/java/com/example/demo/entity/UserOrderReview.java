package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "user_order_review")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userOrder"})
public class UserOrderReview {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user_order_review")
  @SequenceGenerator(name = "seq_user_order_review", sequenceName = "seq_user_order_review_id", allocationSize = 25)
  private Long id;
  @OneToOne
  @JoinColumn(name = "user_order_id", foreignKey = @ForeignKey(name = "fk_user_order_review__user_order_id__user_order__id"), nullable = false, unique = true)
  private UserOrder userOrder;
  @Column(name = "review_at", nullable = false)
  private LocalDateTime reviewAt;
  @Lob
  @Column(name = "review", columnDefinition = "TEXT NOT NULL")
  private String review;
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

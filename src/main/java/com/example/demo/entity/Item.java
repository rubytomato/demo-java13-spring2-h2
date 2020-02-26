package com.example.demo.entity;

import com.example.demo.type.ModelType;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "item")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"itemStocks"})
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_item")
  @SequenceGenerator(name = "seq_item", sequenceName = "seq_item_id", allocationSize = 25)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_item__category_id__category__id"), nullable = false)
  private Category category;
  @Column(name = "name", length = 90, nullable = false)
  private String name;
  @Column(name = "price", nullable = false)
  private Integer price;
  @Column(name = "sales_from", nullable = false)
  private LocalDate salesFrom;
  @Column(name = "sales_to", nullable = false)
  private LocalDate salesTo;
  @Column(name = "model_type", nullable = false)
  private ModelType modelType;
  @Column(name = "create_at", nullable = false)
  @JsonIgnore
  private LocalDateTime createAt;
  @Column(name = "update_at", nullable = false)
  @JsonIgnore
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ItemStock> itemStocks;

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

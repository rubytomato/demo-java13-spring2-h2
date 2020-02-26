package com.example.demo.type;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ModelType {
  A(10),
  B(20),
  C(30),
  D(40),
  E(50),
  F(60),
  G(70),
  H(80),
  I(90),
  J(100);

  private Integer type;
  private static final Map<Integer, ModelType> lookup;

  static {
    lookup = Stream.of(values()).collect(Collectors.toMap(ModelType::getType, Function.identity()));
  }

  ModelType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public static ModelType get(Integer type) {
    return lookup.get(type);
  }

}

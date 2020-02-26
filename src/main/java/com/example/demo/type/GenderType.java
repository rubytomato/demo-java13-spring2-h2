package com.example.demo.type;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GenderType {
  M(0),
  F(1)
  ;

  private Integer type;
  private static final Map<Integer, GenderType> lookup;

  static {
    lookup = Stream.of(values()).collect(Collectors.toMap(GenderType::getType, Function.identity()));
  }

  GenderType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public static GenderType get(Integer type) {
    return lookup.get(type);
  }

}

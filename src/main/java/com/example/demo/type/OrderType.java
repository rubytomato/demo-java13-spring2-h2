package com.example.demo.type;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OrderType {
  SHOP(0),
  ONLINE(1)
  ;

  private Integer type;
  private static final Map<Integer, OrderType> lookup;

  static {
    lookup = Stream.of(values()).collect(Collectors.toMap(OrderType::getType, Function.identity()));
  }

  OrderType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public static OrderType get(Integer type) {
    return lookup.get(type);
  }

}

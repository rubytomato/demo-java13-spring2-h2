package com.example.demo.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderTypeConverter implements AttributeConverter<OrderType, Integer> {
  @Override
  public Integer convertToDatabaseColumn(OrderType orderType) {
    if (orderType == null) {
      return null;
    }
    return orderType.getType();
  }

  @Override
  public OrderType convertToEntityAttribute(Integer type) {
    if (type == null) {
      return null;
    }
    return OrderType.get(type);
  }
}

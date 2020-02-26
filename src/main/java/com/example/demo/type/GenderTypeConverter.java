package com.example.demo.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderTypeConverter implements AttributeConverter<GenderType, Integer> {
  @Override
  public Integer convertToDatabaseColumn(GenderType genderType) {
    if (genderType == null) {
      return null;
    }
    return genderType.getType();
  }
  @Override
  public GenderType convertToEntityAttribute(Integer type) {
    if (type == null) {
      return null;
    }
    return GenderType.get(type);
  }
}

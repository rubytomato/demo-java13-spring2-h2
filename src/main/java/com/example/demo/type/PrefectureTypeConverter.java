package com.example.demo.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PrefectureTypeConverter implements AttributeConverter<PrefectureType, Integer> {
  @Override
  public Integer convertToDatabaseColumn(PrefectureType prefectureType) {
    if (prefectureType == null) {
      return null;
    }
    return prefectureType.getType();
  }

  @Override
  public PrefectureType convertToEntityAttribute(Integer type) {
    if (type == null) {
      return null;
    }
    return PrefectureType.get(type);
  }
}

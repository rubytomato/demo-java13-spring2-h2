package com.example.demo.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ModelTypeConverter implements AttributeConverter<ModelType, Integer> {
  @Override
  public Integer convertToDatabaseColumn(ModelType modelType) {
    if (modelType == null) {
      return null;
    }
    return modelType.getType();
  }
  @Override
  public ModelType convertToEntityAttribute(Integer type) {
    if (type == null) {
      return null;
    }
    return ModelType.get(type);
  }
}

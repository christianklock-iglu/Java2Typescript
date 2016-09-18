package de.klock.typescript.transpiler.clazz;

import de.klock.typescript.transpiler.field.TsField;
import de.klock.typescript.transpiler.type.TsType;

import java.util.List;

public class TsClass {

  private String name;
  private List<TsType> typeArguments;
  private TsType superType;
  private List<TsField> fields;

  public TsClass(String name, List<TsType> typeArguments, TsType superType, List<TsField> fields) {
    this.name = name;
    this.typeArguments = typeArguments;
    this.superType = superType;
    this.fields = fields;
  }

  public String getName() {
    return name;
  }

  public List<TsType> getTypeArguments() {
    return typeArguments;
  }

  public TsType getSuperType() {
    return superType;
  }

  public List<TsField> getFields() {
    return fields;
  }
}


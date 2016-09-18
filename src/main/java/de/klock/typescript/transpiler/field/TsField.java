package de.klock.typescript.transpiler.field;

import de.klock.typescript.transpiler.Configuration;
import de.klock.typescript.transpiler.type.TsType;

import java.io.IOException;
import java.io.Writer;

public class TsField {
  private String name;
  private TsType type;
  private boolean optional;

  public TsField(String name, TsType type, boolean optional) {
    this.name = name;
    this.type = type;
    this.optional = optional;
  }

  public String getName() {
    return name;
  }

  public TsType getType() {
    return type;
  }

  public boolean isOptional() {
    return optional;
  }
}

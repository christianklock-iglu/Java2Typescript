package de.klock.typescript.transpiler.type;

public class TsClassType implements TsType {
  private String name;

  public TsClassType(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}

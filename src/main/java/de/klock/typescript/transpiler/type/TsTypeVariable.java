package de.klock.typescript.transpiler.type;

public class TsTypeVariable implements TsType {
  private String name;

  public TsTypeVariable(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}

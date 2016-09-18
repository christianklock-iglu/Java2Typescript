package de.klock.typescript.transpiler.type;

public class TsArrayType implements TsType {
  private TsType componentType;

  public TsArrayType(TsType componentType) {
    this.componentType = componentType;
  }

  public TsType getComponentType() {
    return componentType;
  }

  @Override
  public String getName() {
    return componentType.getName() + "[]";
  }


}

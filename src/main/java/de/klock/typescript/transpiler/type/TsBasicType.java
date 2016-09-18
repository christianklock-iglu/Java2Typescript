package de.klock.typescript.transpiler.type;

public class TsBasicType implements TsType {
  public static final TsBasicType STRING_TYPE = new TsBasicType("string");
  public static final TsBasicType NUMBER_TYPE = new TsBasicType("number");
  public static final TsBasicType BOOLEAN_TYPE = new TsBasicType("boolean");
  public static final TsBasicType ANY_TYPE = new TsBasicType("any");
  public static final TsBasicType VOID_TYPE = new TsBasicType("void");

  private String name;

  private TsBasicType(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}

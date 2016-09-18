package de.klock.typescript.transpiler.type;

import java.util.List;

public class TsGenericType implements TsType {
  private TsType rawType;
  private List<TsType> typeArguments;

  public TsGenericType(TsType rawType, List<TsType> typeArguments) {
    this.rawType = rawType;
    this.typeArguments = typeArguments;
  }

  @Override
  public String getName() {
    StringBuilder sb = new StringBuilder();
    sb.append(rawType.getName());
    if (!typeArguments.isEmpty()) {
      sb.append("<");
      for (int i = 0; i < typeArguments.size() - 1; i++) {
        sb.append(typeArguments.get(i).getName());
        sb.append(",");
      }
      sb.append(typeArguments.get(typeArguments.size() - 1).getName());
    }
    sb.append(">");
    return sb.toString();
  }
}

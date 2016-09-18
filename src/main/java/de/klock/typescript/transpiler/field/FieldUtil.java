package de.klock.typescript.transpiler.field;

import de.klock.typescript.transpiler.type.TypeUtil;

import java.lang.reflect.Field;

public class FieldUtil {

  public static TsField getField(Field field) {
    return new TsField(field.getName(), TypeUtil.getType(field.getGenericType()), false);
  }

}

package de.klock.typescript.transpiler.clazz;

import de.klock.typescript.transpiler.Configuration;
import de.klock.typescript.transpiler.field.FieldUtil;
import de.klock.typescript.transpiler.field.TsField;
import de.klock.typescript.transpiler.type.TsType;
import de.klock.typescript.transpiler.type.TypeUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClassUtil {

  public static TsClass getClass(Class<?> clazz) {
    return new TsClass(Configuration.translateClassName(clazz), getTypeArguments(clazz), getSuperType(clazz), getFields(clazz));
  }

  private static List<TsField> getFields(Class<?> clazz) {
    List<TsField> result = new ArrayList<>();
    for (Field field : clazz.getDeclaredFields()) {
      result.add(FieldUtil.getField(field));
    }
    return result;
  }

  private static TsType getSuperType(Class<?> clazz) {
    return Object.class.equals(clazz.getSuperclass()) ? null : TypeUtil.getType(clazz.getGenericSuperclass());
  }

  private static List<TsType> getTypeArguments(Class<?> clazz) {
    List<TsType> result = new ArrayList<>();
    for (Type type : clazz.getTypeParameters()) {
      result.add(TypeUtil.getType(type));
    }
    return result;
  }
}

package de.klock.typescript.transpiler.type;

import de.klock.typescript.transpiler.Configuration;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.LinkedList;
import java.util.List;

public class TypeUtil {

  public static TsType getType(Type jType) {
    if (jType instanceof Class<?>) {
      Class<?> clazz = (Class<?>) jType;
      if (Boolean.class.equals(clazz) || boolean.class.equals(clazz)) {
        return TsBasicType.BOOLEAN_TYPE;
      } else if (String.class.equals(clazz)
        || Character.class.equals(clazz) || char.class.equals(clazz)) {
        return TsBasicType.STRING_TYPE;
      } else if (Byte.class.equals(clazz) || byte.class.equals(clazz)
        || Short.class.equals(clazz) || short.class.equals(clazz)
        || Integer.class.equals(clazz) || int.class.equals(clazz)
        || Long.class.equals(clazz) || long.class.equals(clazz)
        || Float.class.equals(clazz) || float.class.equals(clazz)
        || Double.class.equals(clazz) || double.class.equals(clazz)) {
        return TsBasicType.NUMBER_TYPE;
      } else if (Void.class.equals(clazz)) {
        return TsBasicType.VOID_TYPE;
      }
      // TODO add collection handling here
      // TODO add map handling here
      // TODO add Jackson Shape handling here, e.g. as with Date
      else if (clazz.isArray()) {
        TsType componentType = getType(clazz.getComponentType());
        return new TsArrayType(componentType);
      } else {
        return new TsClassType(Configuration.translateClassName(clazz));
      }
    } else if (jType instanceof GenericArrayType) {
      GenericArrayType gat = (GenericArrayType) jType;
      TsType componentType = getType(gat.getGenericComponentType());
      return new TsArrayType(componentType);
    } else if (jType instanceof ParameterizedType) {
      ParameterizedType pt = (ParameterizedType) jType;
      TsType rawType = getType(pt.getRawType());
      List<TsType> typeArguments = new LinkedList<>();
      for (Type ata : pt.getActualTypeArguments()) {
        typeArguments.add(getType(ata));
      }
      return new TsGenericType(rawType, typeArguments);
    } else if (jType instanceof TypeVariable) {
      TypeVariable tv = (TypeVariable) jType;
      return new TsTypeVariable(tv.getName());
    }
    throw new RuntimeException("Unsupported type of java.lang.reflect.Type (" + jType.getClass() + ") for " + jType);
  }
}

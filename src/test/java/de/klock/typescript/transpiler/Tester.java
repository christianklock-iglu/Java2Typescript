package de.klock.typescript.transpiler;

import de.klock.typescript.transpiler.clazz.ClassUtil;
import de.klock.typescript.transpiler.clazz.TsClass;
import de.klock.typescript.transpiler.type.TypeUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Tester {

  public static void main(String[] args) throws IOException {
    Class<?> clazz = Quadrupel.class;

    System.out.println(clazz.getCanonicalName());
    System.out.println(Arrays.toString(clazz.getTypeParameters()));

    System.out.println(clazz.getGenericSuperclass());

    System.out.println("{");
    for (Field field : clazz.getDeclaredFields()) {
      System.out.println("  " + field.getName() + ":" + TypeUtil.getType(field.getGenericType()).getName() + ";");
    }
    System.out.println("}");

    TsClass tsClass = ClassUtil.getClass(clazz);
    PrintWriter pw = new PrintWriter(System.out);
    tsClass.writeTo(pw, new Configuration());
    pw.close();
  }

}

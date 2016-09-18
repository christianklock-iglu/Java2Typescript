package de.klock.typescript.transpiler.visitor;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public interface TypeVisitor {
  void visitClass(Class clazz);
  void visitField(Field field);
  void visitType(Type type);
}

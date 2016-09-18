package de.klock.typescript.transpiler;

import de.klock.typescript.api.ApiMethod;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Generator {

  private List<Class<? extends ApiMethod>> apiMethodClasses;

  private List<Class<?>> todo = new LinkedList<>();
  private Set<Class<?>> done = new HashSet<>();

  public Generator(Class<? extends ApiMethod>... apiMethodClasses) {
    this.apiMethodClasses = Arrays.asList(apiMethodClasses);
  }

  public void run() {
    for (Class<? extends ApiMethod> apiMethodClass : apiMethodClasses) {
      addRequestAndResponseToToDo(apiMethodClass);
      while (!todo.isEmpty()) {
        Class<?> clazz = todo.get(0);
        processClass(clazz);
        todo.remove(0);
        done.add(clazz);
      }
    }
  }

  private void processClass(Class<?> clazz) {
  }

  private void addRequestAndResponseToToDo(Class<? extends ApiMethod> apiMethodClass) {
    ApiMethodUtils.RequestResponseHolder requestResponseHolder = ApiMethodUtils.findRequestAndResponseClass(apiMethodClass);
    todo.add(requestResponseHolder.getRequestClass());
    todo.add(requestResponseHolder.getResponseClass());
  }

  private void addClassToToDoIfRequired(Class<?> clazz) {
    if (Boolean.class.equals(clazz) || boolean.class.equals(clazz)
      || String.class.equals(clazz)
      || Character.class.equals(clazz) || char.class.equals(clazz)
      || Byte.class.equals(clazz) || byte.class.equals(clazz)
      || Short.class.equals(clazz) || short.class.equals(clazz)
      || Integer.class.equals(clazz) || int.class.equals(clazz)
      || Long.class.equals(clazz) || long.class.equals(clazz)
      || Float.class.equals(clazz) || float.class.equals(clazz)
      || Double.class.equals(clazz) || double.class.equals(clazz)
      || Date.class.equals(clazz)) {
    } else if (Collection.class.isAssignableFrom(clazz)) {
      // TODO
    } else if (clazz.isArray()) {
      Class<?> componentType = clazz.getComponentType();
      if (!done.contains(componentType) && !todo.contains(componentType)) {
        todo.add(componentType);
      }
    } else {
      todo.add(clazz);
    }
  }

}

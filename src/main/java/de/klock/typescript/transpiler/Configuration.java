package de.klock.typescript.transpiler;

public class Configuration {



  public static String translateClassName(Class<?> clazz) {
    return clazz.getCanonicalName().replace("de.klock.typescript.", "").replace('.', '_');
  }


}

package de.klock.typescript.transpiler;

import de.klock.typescript.methods.GetData;

public class Main {

  public static void main(String[] args) {
    Generator generator = new Generator(GetData.class);
    generator.run();
  }
}

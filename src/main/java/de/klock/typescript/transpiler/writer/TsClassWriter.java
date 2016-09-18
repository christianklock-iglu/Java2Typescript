package de.klock.typescript.transpiler.writer;

import de.klock.typescript.transpiler.clazz.TsClass;

import java.io.IOException;
import java.io.Writer;

public interface TsClassWriter {
  void write(TsClass clazz, Writer writer ) throws IOException;
}

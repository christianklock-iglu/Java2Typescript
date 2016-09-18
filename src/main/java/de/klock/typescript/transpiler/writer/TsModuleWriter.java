package de.klock.typescript.transpiler.writer;

import de.klock.typescript.transpiler.field.TsField;
import de.klock.typescript.transpiler.module.TsModule;

import java.io.IOException;
import java.io.Writer;

public interface TsModuleWriter {
  void write(TsModule module, Writer writer) throws IOException;
}

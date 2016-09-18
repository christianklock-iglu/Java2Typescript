package de.klock.typescript.transpiler.writer;

import de.klock.typescript.transpiler.field.TsField;

import java.io.IOException;
import java.io.Writer;

public interface TsFieldWriter {
  void write(TsField field, Writer writer) throws IOException;
}

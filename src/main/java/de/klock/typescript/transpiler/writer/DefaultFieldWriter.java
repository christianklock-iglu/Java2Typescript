package de.klock.typescript.transpiler.writer;

import de.klock.typescript.transpiler.Configuration;
import de.klock.typescript.transpiler.field.TsField;

import java.io.IOException;
import java.io.Writer;

public class DefaultFieldWriter implements TsFieldWriter{

  @Override
  public void write(TsField field, Writer writer) throws IOException {
    writer.write(field.getName() + (field.isOptional() ? "?" : "") + ": " + field.getType().getName() + ";");

  }
}

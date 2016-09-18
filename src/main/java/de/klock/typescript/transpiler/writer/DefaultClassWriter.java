package de.klock.typescript.transpiler.writer;

import de.klock.typescript.transpiler.clazz.TsClass;
import de.klock.typescript.transpiler.field.TsField;

import java.io.IOException;
import java.io.Writer;

public class DefaultClassWriter implements TsClassWriter {

  private WriterConfiguration conf;

  public DefaultClassWriter(WriterConfiguration conf) {
    this.conf = conf;
  }

  @Override
  public void write(TsClass clazz, Writer writer) throws IOException {
    writer.write("export interface " + clazz.getName());
    if (!clazz.getTypeArguments().isEmpty()) {
      writer.write("<");
      for (int i = 0; i < clazz.getTypeArguments().size() - 1; i++) {
        writer.write(clazz.getTypeArguments().get(i).getName());
        writer.write(",");
      }
      writer.write(clazz.getTypeArguments().get(clazz.getTypeArguments().size() - 1).getName());
      writer.write(">");
    }
    if (clazz.getSuperType() != null) {
      writer.write(" extends " + clazz.getSuperType().getName());
    }
    writer.write("{" + conf.getNewLine());
    conf.increaseIndentation();
    for (TsField field : clazz.getFields()) {
      field.writeTo(writer, conf);
    }
    conf.decreaseIndentation();
    writer.write(conf.getIndentation() + "}");
  }
}

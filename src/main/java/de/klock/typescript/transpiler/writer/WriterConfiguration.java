package de.klock.typescript.transpiler.writer;

public class WriterConfiguration {

  private TsModuleWriter moduleWriter;
  private TsClassWriter classWriter;
  private TsFieldWriter fieldWriter;

  private int indentationLevel = 0;
  private String singleIndentation = "  ";




  public void increaseIndentation() {
    indentationLevel++;
  }

  public void decreaseIndentation() {
    indentationLevel--;
  }

  public String getIndentation() {
    String indentation = "";
    for (int i = 0; i < indentationLevel; i++) {
      indentation += singleIndentation;
    }
    return indentation;
  }

  public String getNewLine() {
    return "\n";
  }

}

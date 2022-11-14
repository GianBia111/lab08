package it.unibo.mvc.api;
import java.io.File;
import java.nio.file.Path;
import java.lang.*;

public interface IOController {
    void setCurrentFile(File _file);
    File getCurrentFile();
    Path getCurrentFilePath();
    void writeString(String s);
}

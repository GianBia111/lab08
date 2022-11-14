package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import it.unibo.mvc.api.IOController;

/**
 * Application controller. Performs the I/O.
 */
public class Controller implements IOController{

    private File _file=null;
    public static final String HOME_DIR=System.getProperty("user.home"); 
    public static final String SEPARATOR=System.getProperty("file.separator");
    public static final String DEFAULT_FILE="output.txt";


    public Controller(){
        _file=new File(HOME_DIR+""+SEPARATOR+""+DEFAULT_FILE);
    }

    @Override
    public File getCurrentFile(){
        return this._file;
    }

    @Override
    public void setCurrentFile(File _file){
        this._file=_file;
    }

    @Override
    public Path getCurrentFilePath(){
        return this._file.toPath();
    }

    @Override
    public void writeString(String s){
        try{
            BufferedWriter bfw=new BufferedWriter(new FileWriter(this._file));
            bfw.write(s);
            bfw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }


}

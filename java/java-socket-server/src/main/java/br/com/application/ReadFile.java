package br.com.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {
    static final Logger logger = LogManager.getLogger(ReadFile.class.getName());
    private final File file;

    public ReadFile(String filePath){
        this.file = new File(filePath);
    }

    public String read() {
        String fileContent = "";
        try {
            Scanner myReader = new Scanner(this.file);
            while (myReader.hasNextLine()) {
                fileContent = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            logger.error("is not possible read file content | " + e.getMessage());
        }
        return fileContent;
    }

}

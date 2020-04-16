package dk.sdu.tek.persistance;

import dk.sdu.tek.domain.*;

import java.io.*;
import java.util.Scanner;

public class Writer {

    public void writeToFile(String fileName, String object) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        String directory = "src/main/java/dk/sdu/tek/domain/";
        try {
            fileWriter = new FileWriter(directory+=fileName, true);
            printWriter = new PrintWriter(fileWriter);
            String textToAppend = object;
            printWriter.println(textToAppend);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}

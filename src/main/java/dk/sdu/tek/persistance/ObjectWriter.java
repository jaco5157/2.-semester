package dk.sdu.tek.persistance;


import java.io.*;

public class ObjectWriter {

    private String fileName;

    public ObjectWriter(String fileName) {
        this.fileName = "src/main/java/dk/sdu/tek/domain/" + fileName;
    }

    public void writeToFile(String object) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(this.fileName, true);
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

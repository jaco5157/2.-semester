package dk.sdu.tek.persistance;


import java.io.*;

public class ObjectWriter {

    private static String path;

    public static void writeToFile(String fileName, String object) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        path = "src/main/java/dk/sdu/tek/domain/" + fileName;

        try {
            fileWriter = new FileWriter(fileName, true);
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

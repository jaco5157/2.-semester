package dk.sdu.tek.persistance;


import java.io.*;

public class ObjectWriter {

    private static String path;

    public static void writeToFile(String fileName, Object object) {
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileOutputStream(new File("src/main/java/dk/sdu/tek/domain/" + fileName), true));
            printWriter.append(object.toString()+"\n");
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

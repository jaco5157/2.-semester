package dk.sdu.tek.domain;

import dk.sdu.tek.persistance.*;
import dk.sdu.tek.presentation.AdminMenu;
import dk.sdu.tek.presentation.Menu;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements IO{
    @Override
    public Menu getMenu() {
        return new AdminMenu();
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public void createProducer (String username, String password) {
        Producer producer1 = new Producer ("producer1", "pass123");
    }

    @Override
    public List read() {
        return null;
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("admins.txt", this.toString());
    }

    /*
    public void createProducer(String username, String password) throws FileNotFoundException {
        username = "";
        password = "";
        try {
            Scanner in = new Scanner(System.in);
            in.useDelimiter("[,\n]");
            FileWriter outFile = new FileWriter("members.txt", true);
            BufferedWriter bw = new BufferedWriter(outFile);
            PrintWriter out = new PrintWriter(outFile);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                out.println(line);
            }
            System.out.println("Producer has been added");
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  */
}

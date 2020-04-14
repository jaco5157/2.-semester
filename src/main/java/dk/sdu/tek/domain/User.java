package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {

    private String filepath = "src/main/java/dk/sdu/tek/domain/members.txt";

    public Menu getMenu() {
        return null;
    }

    public boolean authenticate(TextField one, TextField two) {
        Scanner scan;
        String tempUsername = "";
        String tempPassword = "";

        try {
            scan = new Scanner(new File(filepath));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext()) {
                tempUsername = scan.next();
                tempPassword = scan.next();

                if(tempUsername.trim().equals(one.getText()) && tempPassword.trim().equals(two.getText())) {
                    return true;
                }
            }
            scan.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Password file not found");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

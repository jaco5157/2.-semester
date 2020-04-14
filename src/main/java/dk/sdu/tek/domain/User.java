package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.Scanner;

public class User {

    private static Scanner scan;
    private String filepath = "/main/java/resources/dk/sdu/tek/presentation/members.txt";

    public Menu getMenu() {
        return null;
    }

    public boolean authenticate(TextField one, TextField two) {
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
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

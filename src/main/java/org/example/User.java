package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class User {

    private static Scanner scan;
    private String filepath = "members.txt";

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

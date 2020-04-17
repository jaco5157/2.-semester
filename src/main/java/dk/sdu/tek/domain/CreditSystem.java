package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditSystem {
    private Visitor currentUser;

    public boolean authenticate(TextField one, TextField two) {
        String tempUsername = "";
        String tempPassword = "";

        ObjectReader.readObject()

        if(tempUsername.trim().equals(one.getText()) && tempPassword.trim().equals(two.getText())) {
            return true;
        }

        return false;
    }

    public 

    public void setCurrentUser (Visitor currentUser) {
        this.currentUser = currentUser;
    }

    public Visitor getCurrentUser() {
        return currentUser;
    }

}

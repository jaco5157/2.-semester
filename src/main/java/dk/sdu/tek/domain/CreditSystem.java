package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import static dk.sdu.tek.persistence.ObjectReader.Type.ADMIN;
import static dk.sdu.tek.persistence.ObjectReader.Type.PRODUCER;

import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreditSystem {
    private Visitor currentUser;

    public boolean authenticate(TextField username, TextField password, Boolean isAdmin) {
        ArrayList<User> userList;

        if(isAdmin) {
            userList = ObjectReader.readObject(ADMIN);
        } else {
            userList = ObjectReader.readObject(PRODUCER);
        }
        for (User user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public void setCurrentUser (Visitor currentUser) {
        this.currentUser = currentUser;
    }

    public Visitor getCurrentUser() {
        return currentUser;
    }

}

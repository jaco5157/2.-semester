package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class User extends Visitor implements Writeable {

    private String username;
    private String password;

    //private URL url = getClass().getResource("members.txt");
    private String filepath = "src/main/java/dk/sdu/tek/domain/members.txt";

    public Menu getMenu() {
        return null;
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void createProduction() {

    }

    public void createPerson(String name) {

    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

    @Override
    public String toString() {
        return this.username + "," + this.password;
    }

}

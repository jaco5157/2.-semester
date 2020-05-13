package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class User extends Visitor implements Writeable{

    private int id;
    private String username;
    private String password;

    public Menu getMenu() {
        return null;
    }

    public User (int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Brugernavn: " + this.getUsername() + "\nBruger ID: " + this.getId();
    }

    public abstract ObservableList<ObservableObject> getOwnedProductions();

    public abstract ObservableObject getOwnedProduction(int productionID);

    public abstract ObservableList<ObservableObject> getOwnedCredits();

    //Get and set attributes
    public int getId () {return this.id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername () {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword () {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

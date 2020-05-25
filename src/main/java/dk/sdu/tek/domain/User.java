package dk.sdu.tek.domain;

import javafx.collections.ObservableList;

public abstract class User implements Writeable{

    private int id;
    private String username;
    private String password;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
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

    public abstract Production getOwnedProduction(int productionID);

    public abstract ObservableList<ObservableObject> getOwnedCredits();

    //Getters
    public int getId () {return this.id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

}

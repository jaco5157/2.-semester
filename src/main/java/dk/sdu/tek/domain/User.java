package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;

import java.util.ArrayList;

public abstract class User extends Visitor implements Writeable {

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

    public void createPerson(String name, int id, String contactInfo) {
        Person person = new Person(id, name, contactInfo);
        person.write();
    }

    public abstract ArrayList<Production> getOwnedProductions();

    public abstract Production getOwnedProduction(int productionID);

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

    public int getId () {return this.id;}

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.username + "," + this.password;
    }

}

package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import dk.sdu.tek.presentation.Menu;

import java.util.ArrayList;

public abstract class User extends Visitor implements Writeable {

    private String username;
    private String password;

    public Menu getMenu() {
        return null;
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void createProduction(String productionName, int productionID, int producerID) {
        Production production = new Production(productionName, productionID, producerID);
        production.write();
    }

    public void createPerson(String name, int personID, String contactInfo) {
        Person person = new Person(name, personID, contactInfo);
        person.write();
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

    public abstract ArrayList<Production> getProductions ();

}

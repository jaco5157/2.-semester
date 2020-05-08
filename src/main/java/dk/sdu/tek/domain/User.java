package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;

public abstract class User extends Visitor implements Writeable {

    @BsonProperty("_id")
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
        return this.username + "," + this.password;
    }

    public abstract ArrayList<Production> getOwnedProductions();

    public abstract Production getOwnedProduction(int productionID);

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

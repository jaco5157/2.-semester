package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import dk.sdu.tek.persistence.ObjectWriter;
import dk.sdu.tek.presentation.AdminMenu;
import dk.sdu.tek.presentation.Menu;

import java.util.ArrayList;

public class Admin extends User {
    @Override
    public Menu getMenu() {
        return new AdminMenu();
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public ArrayList<Production> getOwnedProductions() {
        return Singleton.getInstance().getProductions();
    }

    @Override
    public Production getOwnedProduction(int productionID) {
        return Singleton.getInstance().getProduction(productionID);
    }

    public void createProducer (String username, String password, int producerID) {
        Producer producer = new Producer (username, password, producerID);
        producer.write();
    }

    public void createProduction(String productionName, int productionID, int producerID) {
        Production production = new Production(productionName, productionID, producerID);
        production.write();
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("admins.txt", this);
    }


}

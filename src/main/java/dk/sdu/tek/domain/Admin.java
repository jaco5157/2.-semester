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
    public Production getProduction(int productionID) {
        for(Production production : this.getProductions()) {
            if(production.getProductionID() == productionID) {
                return production;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Production> getProductions() {
        return ObjectReader.readObject(ObjectReader.Type.PRODUCTION);
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

package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import dk.sdu.tek.presentation.AdminMenu;
import dk.sdu.tek.presentation.Menu;

import java.util.ArrayList;

public class Admin extends User {

    public Admin(int id, String username, String password) {
        super(id, username, password);
    }

    public void createProducer (int id, String username, String password) {
        Producer producer = new Producer (id, username, password);
        producer.write();
    }

    public void createProduction(int id, String productionName, int producerID) {
        Production production = new Production(id, productionName, producerID);
        production.write();
    }

    public void deleteProduction(Production production) {

    }

    @Override
    public void write() {
        PersistenceHandler.getInstance().createAdmin(this);
    }

    @Override
    public String toString() {
        return this.getUsername() + "," + this.getPassword() + "," + this.getId();
    }

    @Override
    public Menu getMenu() {
        return new AdminMenu();
    }

    @Override
    public ArrayList<Production> getOwnedProductions() {
        return CreditSystem.getInstance().getProductions();
    }

    @Override
    public Production getOwnedProduction(int productionID) {
        return CreditSystem.getInstance().getProduction(productionID);
    }
}

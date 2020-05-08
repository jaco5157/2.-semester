package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;
import dk.sdu.tek.persistence.PersistenceHandler;
import dk.sdu.tek.presentation.Menu;
import dk.sdu.tek.presentation.ProducerMenu;

import java.util.ArrayList;

public class Producer extends User {

    public Producer(int id, String username, String password){
        super(id, username, password);
    }

    @Override
    public Menu getMenu() {
        return new ProducerMenu();
    }

    @Override
    public void write() {
        PersistenceHandler.getInstance().createProducer(this);
    }

    @Override
    public String toString() {
        return this.getUsername() + "," + this.getPassword() + "," + this.getId();
    }

    @Override
    public ArrayList<Production> getOwnedProductions() {
        ArrayList<Production> productions = new ArrayList<>();

        for (Production production : CreditSystem.getInstance().getProductions()) {
            if(production.getProducerID() == this.getId()) {
                productions.add(production);
            }
        }

        return productions;
    }


    @Override
    public Production getOwnedProduction(int productionID) {
        for(Production production : this.getOwnedProductions()) {
            if(production.getId() == productionID) {
                return production;
            }
        }
        return null;
    }

    public void createProduction(String productionName, int productionID) {
        Production production = new Production(productionID, productionName, this.getId());
        production.write();
    }
}

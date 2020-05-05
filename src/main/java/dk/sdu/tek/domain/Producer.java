package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import dk.sdu.tek.persistence.ObjectWriter;
import dk.sdu.tek.presentation.Menu;
import dk.sdu.tek.presentation.ProducerMenu;

import java.util.ArrayList;

public class Producer extends User {

    private int producerID;

    @Override
    public Menu getMenu() {
        return new ProducerMenu();
    }

    public Producer(String username, String password, int producerID){
        super(username, password);
        this.producerID = producerID;
    }

    public int getProducerID () {
        return this.producerID;
    }

    public void setProducerID (int producerID) {
        this.producerID = producerID;
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("producers.txt", this);
    }

    @Override
    public String toString() {
        return this.getUsername() + "," + this.getPassword() + "," + this.getProducerID();
    }

    @Override
    public ArrayList<Production> getOwnedProductions() {
        ArrayList<Production> productions = new ArrayList<>();

        for (Production production : Singleton.getInstance().getProductions()) {
            if(production.getProducerID() == this.getProducerID()) {
                productions.add(production);
            }
        }

        return productions;
    }


    @Override
    public Production getOwnedProduction(int productionID) {
        for(Production production : this.getOwnedProductions()) {
            if(production.getProductionID() == productionID) {
                return production;
            }
        }
        return null;
    }

    public void createProduction(String productionName, int productionID) {
        Production production = new Production(productionName, productionID, this.getProducerID());
        production.write();
    }
}

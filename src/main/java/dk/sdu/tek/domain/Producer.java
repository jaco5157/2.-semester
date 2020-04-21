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
    public ArrayList<Production> getProductions () {
        ArrayList<Production> productions = new ArrayList<>();
        ArrayList<Production> fullList = ObjectReader.readObject(ObjectReader.Type.PRODUCTION);

        for (Production production : fullList) {
            if(production.getProducerID() == this.getProducerID()) {
                productions.add(production);
            }
        }

        return productions;
    }
}

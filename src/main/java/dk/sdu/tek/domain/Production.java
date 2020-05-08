package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;

import java.util.ArrayList;

public class Production implements Writeable{

    private int id;
    private String productionName;
    private int producerID;

    public Production(int id, String productionName, int producerID){
        this.id = id;
        this.productionName = productionName;
        this.producerID = producerID;
    }

    @Override
    public String toString() {
        return this.productionName + "," + this.getId() + "," + this.producerID;
    }

    @Override
    public void write() {
        PersistenceHandler.getInstance().createProduction(this);
    }


    public void addCredit(int id, int personID, String role) {
        Credit credit = new Credit(id, this.getId(), personID, role);
        credit.write();
    }

    public Producer getProducer() {
        for(Producer producer : CreditSystem.getInstance().getProducers()) {
            if(producer.getId() == id) {
                return producer;
            }
        }
        return null;
    }

    public ArrayList<Credit> getCredits () {
        ArrayList<Credit> credits = new ArrayList<>();
        ArrayList<Credit> fullList = PersistenceHandler.getInstance().getCredits();

        for (Credit credit : fullList) {
            if(credit.getProductionID() == this.getId()) {
                credits.add(credit);
            }
        }

        return credits;
    }

    //Get and set attributes
    public int getId () {
        return this.id;
    }

    public void setId (int productionID) {
        this.id = id;
    }

    public String getName() {
        return this.productionName;
    }

    public void setName(String productionName) {
        this.productionName = productionName;
    }

    public int getProducerID () {
        return this.producerID;
    }

    public void setProducerID (int producerID) {
        this.producerID = producerID;
    }

}

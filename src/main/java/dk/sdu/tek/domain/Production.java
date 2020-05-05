package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import dk.sdu.tek.persistence.ObjectWriter;

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

    public String getProductionName() {
        return this.productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public int getId () {
        return this.id;
    }

    public void setProductionID (int productionID) {
        this.id = id;
    }

    public int getProducerID () {
        return this.producerID;
    }

    public void setProducerID (int producerID) {
        this.producerID = producerID;
    }

    public Producer getProducer() {
        for(Producer producer : Singleton.getInstance().getProducers()) {
            if(producer.getId() == id) {
                return producer;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.productionName + "," + this.getId() + "," + this.producerID;
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("productions.txt", this);
    }


    public void addCredit(int id, int personID, String role) {
        Credit credit = new Credit(id, this.getId(), personID, role);
        credit.write();
    }

    public ArrayList<Credit> getCredits () {
        ArrayList<Credit> credits = new ArrayList<>();
        ArrayList<Credit> fullList = ObjectReader.readObject(ObjectReader.Type.CREDIT);

        for (Credit credit : fullList) {
            if(credit.getProductionID() == this.getId()) {
                credits.add(credit);
            }
        }

        return credits;
    }

    public ArrayList<Production> getProductions () {
        ArrayList<Production> productions = new ArrayList<>();
        ArrayList<Production> fullListList = ObjectReader.readObject(ObjectReader.Type.PRODUCTION);

        for (Production production : fullListList) {
            if(production.getProductionName() == this.getProductionName()) {
                productions.add(production);
            }
        }
        return productions;
    }


}

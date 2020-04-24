package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import dk.sdu.tek.persistence.ObjectWriter;

import java.util.ArrayList;

public class Production implements Writeable{
    private String productionName;
    private int productionID;
    private int producerID;

    public Production(String productionName, int productionID, int producerID){
        this.productionName = productionName;
        this.productionID = productionID;
        this.producerID = producerID;
    }

    public String getProductionName() {
        return this.productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public int getProductionID () {
        return this.productionID;
    }

    public void setProductionID (int productionID) {
        this.productionID = productionID;
    }

    public int getProducerID () {
        return this.producerID;
    }

    public void setProducerID (int producerID) {
        this.producerID = producerID;
    }

    public Producer getProducer() {
        for(Producer producer : Singleton.getInstance().getProducers()) {
            if(producer.getProducerID() == productionID) {
                return producer;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.productionName + "," + this.productionID + "," + this.producerID;
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("productions.txt", this);
    }

    public void addCredit(int personID, String role) {
        Credit credit = new Credit(personID, this.getProductionID(), role);
        credit.write();
    }

    public ArrayList<Credit> getCredits () {
        ArrayList<Credit> credits = new ArrayList<>();
        ArrayList<Credit> fullList = ObjectReader.readObject(ObjectReader.Type.CREDIT);

        for (Credit credit : fullList) {
            if(credit.getProductionID() == this.getProductionID()) {
                credits.add(credit);
            }
        }

        return credits;
    }
}

package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        return PersistenceHandler.getInstance().getProducer(this.getProducerID());
    }

    public ObservableList<ObservableObject> getCredits () {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for(Credit credit : PersistenceHandler.getInstance().getCredits()) {
            if (credit.getId() == this.getId()) {
                result.add(new ObservableObject(credit.getId(), credit.getRole(), credit.toString()));
            }
        }
        return result;
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

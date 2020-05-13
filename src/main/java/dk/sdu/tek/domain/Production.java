package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        return "Navn: " + this.productionName + "\nProduktions ID: " + this.getId() + "\nProducent: " + PersistenceHandler.getInstance().getProducer(this.producerID).getUsername();
    }

    @Override
    public boolean write() {
        return PersistenceHandler.getInstance().createProduction(this);
    }

    public boolean addCredit(int id, int personID, String role) {
        if (PersistenceHandler.getInstance().getPerson(personID) == null){
            return false;
        }
        return new Credit(id, this.getId(), personID, role).write();
    }

    public Producer getProducer() {
        return PersistenceHandler.getInstance().getProducer(this.getProducerID());
    }

    public ObservableList<ObservableObject> getCredits () {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for(Credit credit : PersistenceHandler.getInstance().getCredits()) {
            if (credit.getProductionID() == this.getId()) {
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

package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;

public class Credit implements Writeable{

    private int id;
    private String role;
    private int personID;
    private int productionID;

    public Credit (int id, int productionID, int personID, String role) {
        this.id = id;
        this.productionID = productionID;
        this.personID = personID;
        this.role = role;
    }

    @Override
    public boolean write() {
        return PersistenceHandler.getInstance().createCredit(this);
    }

    public boolean edit(int id, int productionID, int personID, String role) {
        if (PersistenceHandler.getInstance().getPerson(personID) == null || PersistenceHandler.getInstance().getProduction(productionID) == null){
            return false;
        }
        int oldId = this.id;
        this.id = id;
        if(CreditSystem.getInstance().getIsAdmin()) {
            this.productionID = productionID;
        } else if(PersistenceHandler.getInstance().getProducer(CreditSystem.getInstance().getUserId()).getOwnedProduction(productionID) != null){
            this.productionID = productionID;
        }
        this.personID = personID;
        this.role = role;
        return PersistenceHandler.getInstance().editCredit(oldId, this);
    }

    @Override
    public String toString() {
        return "Rolle: " + this.role + "\nKrediterings ID: " + this.id + "\nProduktion: " + PersistenceHandler.getInstance().getProduction(this.productionID).getName() + "\nNavn: " + PersistenceHandler.getInstance().getPerson(this.personID).getName();
    }

    //Get and set attributes
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPersonID() {
        return this.personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getProductionID() {
        return this.productionID;
    }

    public void setProductionID(int productionID) {
        this.productionID = productionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

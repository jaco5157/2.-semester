package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;

public class Credit implements Writeable{

    private int id;
    private String role;
    private int personID;
    private int productionID;

    public Credit (int productionID, int personID, String role) {
        this.productionID = productionID;
        this.personID = personID;
        this.role = role;
    }

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
        //Check if person and production exists, if user trying to edit the credit is not an admin, check if they own the production
        if (PersistenceHandler.getInstance().getPerson(personID) == null || PersistenceHandler.getInstance().getProduction(productionID) == null || !CreditSystem.getInstance().getIsAdmin() && PersistenceHandler.getInstance().getProducer(CreditSystem.getInstance().getUserId()).getOwnedProduction(productionID) == null){
            return false;
        }
        this.productionID = productionID;
        this.personID = personID;
        this.role = role;
        return PersistenceHandler.getInstance().editCredit(this);
    }

    @Override
    public String toString() {
        return "Rolle: " + this.role + "\nKrediterings ID: " + this.id + "\nProduktion: " + PersistenceHandler.getInstance().getProduction(this.productionID).getName() + "\nNavn: " + PersistenceHandler.getInstance().getPerson(this.personID).getName();
    }

    //Getters
    public String getRole() {
        return role;
    }

    public int getPersonID() {
        return this.personID;
    }

    public int getProductionID() {
        return this.productionID;
    }

    public int getId() {
        return id;
    }
}

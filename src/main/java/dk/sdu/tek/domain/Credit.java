package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;

public class Credit implements Writeable{

    private int id;
    private String role;
    private int personID;
    private int productionID;

    public Credit (int id, int personID, int productionID, String role) {
        this.id = id;
        this.productionID = productionID;
        this.personID = personID;
        this.role = role;
    }

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

    @Override
    public String toString() {
        return this.personID + "," + this.productionID + "," + this.role;
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("credits.txt", this);
    }
}

package dk.sdu.tek.domain;

public class Credit {
    private String role;
    private int personID;
    private int productionId;

    public Credit (int personID, int productionID, String role) {
        this.personID = personID;
        this.productionId = productionID;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    @Override
    public String toString() {
        return this.role;
    }
}

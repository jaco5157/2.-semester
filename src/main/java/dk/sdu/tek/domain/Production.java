package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import dk.sdu.tek.persistence.ObjectWriter;

import java.util.ArrayList;

public class Production implements Writeable{
    private String productionName;
    private int productionID;

    public Production(String productionName, int productionID){
        this.productionName = productionName;
        this.productionID = productionID;
    }

    public int getProductionID () {
        return this.productionID;
    }

    public void setProductionID (int productionID) {
        this.productionID = productionID;
    }

    public String getProductionName() {
        return this.productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    @Override
    public String toString() {
        return this.productionName + "," + this.productionID;
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

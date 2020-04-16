package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;

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
}

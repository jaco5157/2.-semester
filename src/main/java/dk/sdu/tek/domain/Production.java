package dk.sdu.tek.domain;

public class Production {
    private String productionName;

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public Production(String productionName){
        this.productionName = productionName;
    }

    @Override
    public String toString() {
        return this.productionName;
    }
}

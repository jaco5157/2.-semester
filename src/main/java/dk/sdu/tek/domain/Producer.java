package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;
import dk.sdu.tek.presentation.Menu;
import dk.sdu.tek.presentation.ProducerMenu;

public class Producer extends User {

    //private List<Production> productionList;

    @Override
    public Menu getMenu() {
        return new ProducerMenu();
    }

    public Producer(String username, String password){
        super(username, password);
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("producers.txt", this);
    }


//    public List<Production> getProductionList() {
//        return productionList;
//    }
}

package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import dk.sdu.tek.presentation.Menu;
import dk.sdu.tek.presentation.ProducerMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Producer extends User {

    public Producer(String username, String password){
        super(username, password);
    }

    public Producer(int id, String username, String password){
        super(id, username, password);
    }

    @Override
    public Menu getMenu() {
        return new ProducerMenu();
    }

    @Override
    public boolean write() {
        return PersistenceHandler.getInstance().createProducer(this);
    }

    //Slettes?
    @Override
    public ObservableList<ObservableObject> getOwnedProductions() {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for (Production production : PersistenceHandler.getInstance().getProductions()) {
            if(production.getProducerID() == this.getId()) {
                result.add(new ObservableObject(production.getId(), production.getName(), production.toString()));
            }
        }
        return result;
    }

    @Override
    public Production getOwnedProduction(int productionID) {
        Production production = PersistenceHandler.getInstance().getProduction(productionID);
        if(production.getProducerID() == this.getId()) {
            return production;
        }
        return null;
    }

    public ObservableList<ObservableObject> getOwnedCredits() {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for (Production production : PersistenceHandler.getInstance().getProductions()) {
            if(production.getProducerID() == this.getId()) {
                result.addAll(production.getCredits());
            }
        }
        return result;
    }

    public boolean createProduction(String productionName) {
        return new Production(productionName, this.getId()).write();
    }
}

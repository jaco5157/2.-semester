package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import dk.sdu.tek.presentation.Menu;
import dk.sdu.tek.presentation.ProducerMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Producer extends User {

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
    public ObservableObject getOwnedProduction(int productionID) {
        Production production = PersistenceHandler.getInstance().getProduction(productionID);
        if(production.getProducerID() == this.getId()) {
            return new ObservableObject(production.getId(), production.getName(), production.toString());
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

    public boolean createProduction(int productionID, String productionName) {
        return new Production(productionID, productionName, this.getId()).write();
    }
}

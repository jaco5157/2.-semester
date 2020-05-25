package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.ObservableList;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin(int id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public boolean write() {
        return PersistenceHandler.getInstance().createAdmin(this);
    }

    @Override
    public Production getOwnedProduction(int productionID) {
        return PersistenceHandler.getInstance().getProduction(productionID);
    }

    @Override
    public ObservableList<ObservableObject> getOwnedCredits() {
        return CreditSystem.getInstance().getCredits();
    }

}

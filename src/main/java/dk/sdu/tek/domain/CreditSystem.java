package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import java.util.ArrayList;

public class CreditSystem {
    private Visitor currentUser;

    public static CreditSystem instance;

    public static CreditSystem getInstance() {
        if (instance == null) {
            instance = new CreditSystem();
        }
        return instance;
    }

    public boolean authenticate(String username, String password, Boolean isAdmin) {
        ArrayList<Admin> userList = PersistenceHandler.getInstance().getAdmins();
        System.out.println("Is admin: " + isAdmin);
        System.out.println(userList);
        for (Admin admin : userList) {
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                setCurrentUser(admin);
                return true;
            }
        }
        return false;
    }

    public boolean authenticate(String username, String password) {
        ArrayList<Producer> userList = PersistenceHandler.getInstance().getProducers();
        System.out.println(userList);
        for (Producer producer : userList) {
            if (username.equals(producer.getUsername()) && password.equals(producer.getPassword())) {
                setCurrentUser(producer);
                return true;
            }
        }
        return false;
    }

    public void setCurrentUser (Visitor currentUser) {
        this.currentUser = currentUser;
    }

    public Visitor getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Producer> getProducers() {
        return PersistenceHandler.getInstance().getProducers();
    }

    public ArrayList<Production> getProductions() {
        return PersistenceHandler.getInstance().getProductions();
    }

    public Production getProduction(int productionID) {
        return CreditSystem.getInstance().getProduction(productionID);
    }

    public Production getProduction(String name) {
        for(Production production : this.getProductions()) {
            if(production.getProductionName() == name) {
                return production;
            }
        }
        return null;
    }

}

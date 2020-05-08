package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;

import static dk.sdu.tek.persistence.ObjectReader.Type.ADMIN;
import static dk.sdu.tek.persistence.ObjectReader.Type.PRODUCER;
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
        ArrayList userList;
        System.out.println("Is admin: " + isAdmin);
        if(isAdmin) {
            userList = PersistenceHandler.getInstance().getAdmins();
        } else {
            userList = PersistenceHandler.getInstance().getProducers();
        }
        System.out.println(userList);
        for (User user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                setCurrentUser(user);
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
        for(Production production : this.getProductions()) {
            if(production.getId() == productionID) {
                return production;
            }
        }
        return null;
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

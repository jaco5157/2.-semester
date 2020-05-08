package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public ObservableList<ObservableObject> getProducers() {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for(Producer producer : PersistenceHandler.getInstance().getProducers()) {
            result.add(new ObservableObject(producer.getId(),producer.getUsername(), producer.toString()));
        }
        return result;
    }

    public ObservableList<ObservableObject> getProductions() {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for(Production production : PersistenceHandler.getInstance().getProductions()) {
            result.add(new ObservableObject(production.getId(),production.getName(), production.toString()));
        }
        return result;
    }

    public ObservableList<ObservableObject> getPeople() {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for(Person person : PersistenceHandler.getInstance().getPeople()) {
            result.add(new ObservableObject(person.getId(),person.getName(), person.toString()));
        }
        return result;
    }

    public ObservableList<ObservableObject> getCredits() {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for(Credit credit : PersistenceHandler.getInstance().getCredits()) {
            result.add(new ObservableObject(credit.getId(), credit.getRole(), credit.toString()));
        }
        return result;
    }

    public ObservableObject getProduction(int productionID) {
        Production production = PersistenceHandler.getInstance().getProduction(productionID);
        return new ObservableObject(production.getId(),production.getName(), production.toString());
    }

    public ObservableObject getProduction(String name) {
        for(Production production : PersistenceHandler.getInstance().getProductions()) {
            if(production.getName() == name) {
                return new ObservableObject(production.getId(), production.getName(), production.toString());
            }
        }
        return null;
    }

}

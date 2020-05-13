package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CreditSystem {
    private boolean isAdmin;
    private int userId;

    private static CreditSystem instance;

    public static CreditSystem getInstance() {
        if (instance == null) {
            instance = new CreditSystem();
        }
        return instance;
    }

    public boolean authenticate(String username, String password, Boolean isAdmin) {
        if (isAdmin) {
            for (Admin admin : PersistenceHandler.getInstance().getAdmins()) {
                if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                    this.isAdmin = isAdmin;
                    this.userId = admin.getId();
                    return true;
                }
            }
        }
        for (Producer producer : PersistenceHandler.getInstance().getProducers()) {
            if (username.equals(producer.getUsername()) && password.equals(producer.getPassword())) {
                this.isAdmin = isAdmin;
                this.userId = producer.getId();
                return true;
            }
        }
        return false;
    }

    public boolean createProducer (int id, String username, String password) {
        return new Producer(id, username, password).write();
    }

    public boolean createProduction (int id, String name, int producerId) {
        try {
            return PersistenceHandler.getInstance().getProducer(producerId).createProduction(id, name);
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean createPerson (int id, String username, String email) {
        return new Person(id, username, email).write();
    }

    public boolean createCredit (int id, int productionId, int personId, String role) {
        try {
            return PersistenceHandler.getInstance().getProduction(productionId).addCredit(id, personId, role);
        } catch (NullPointerException ex) {
            return false;
        }
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public int getUserId() {
        return userId;
    }
}

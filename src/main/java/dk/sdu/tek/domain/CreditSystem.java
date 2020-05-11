package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CreditSystem {
    private Producer producer;
    private Admin admin;

    private static CreditSystem instance;

    public static CreditSystem getInstance() {
        if (instance == null) {
            instance = new CreditSystem();
        }
        return instance;
    }

    public boolean authenticate(String username, String password, Boolean isAdmin) {
<<<<<<< Updated upstream
        if(isAdmin) {
            for (Admin admin : PersistenceHandler.getInstance().getAdmins()) {
                if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                    setCurrentUser(admin);
=======
        if (isAdmin) {
            ArrayList<Admin> userList = PersistenceHandler.getInstance().getAdmins();
            for (Admin admin : userList) {
                if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                    this.admin = admin;
>>>>>>> Stashed changes
                    return true;
                }
            }
        } else {
<<<<<<< Updated upstream
            for (Producer producer : PersistenceHandler.getInstance().getProducers()) {
                if (username.equals(producer.getUsername()) && password.equals(producer.getPassword())) {
                    setCurrentUser(producer);
=======
            ArrayList<Producer> userList = PersistenceHandler.getInstance().getProducers();
            for (Producer producer : userList) {
                if (username.equals(producer.getUsername()) && password.equals(producer.getPassword())) {
                    this.producer = producer;
>>>>>>> Stashed changes
                    return true;
                }
            }
        }
        return false;
    }

//    public Visitor getCurrentUser() {
//        return currentUser;
//    }

    public boolean createProducer (int id, String username, String password) {
        return PersistenceHandler.getInstance().createProducer(new Producer(id, username, password));
    }

    public boolean createProduction (int id, String username, int proucerId) {
        return PersistenceHandler.getInstance().createProduction(new Production(id, username, proucerId));
    }

    public boolean createPerson (int id, String username, String email) {
        return PersistenceHandler.getInstance().createPerson(new Person(id, username, email));
    }

    public boolean createCredit (int id, int productionId, int personId, String role) {
        return PersistenceHandler.getInstance().createCredit(new Credit(id, productionId, personId, role));
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

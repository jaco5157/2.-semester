package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person implements Writeable{

    private int id;
    private String name;
    private String contactInfo;

    public Person(int id, String name, String contactInfo){
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    @Override
    public boolean write() {
        return PersistenceHandler.getInstance().createPerson(this);
    }

    @Override
    public String toString() {
        return "Navn: " + this.name + "\nPerson ID: " + this.id + "\nKontakt info: " + this.contactInfo;
    }

    public ObservableList<ObservableObject> getCredits () {
        ObservableList<ObservableObject> result = FXCollections.observableArrayList();
        for(Credit credit : PersistenceHandler.getInstance().getCredits()) {
            if (credit.getPersonID() == this.getId()) {
                result.add(new ObservableObject(credit.getId(), credit.getRole(), credit.toString()));
            }
        }
        return result;
    }

    //Get and set attributes
    public String getName() {
        return name;
    }

    public void setName(String person) {
        this.name = person;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

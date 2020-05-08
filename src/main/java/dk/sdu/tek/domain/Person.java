package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;
import dk.sdu.tek.persistence.PersistenceHandler;

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
    public void write() {
        PersistenceHandler.getInstance().createPerson(this);
    }

    @Override
    public String toString() {
        return this.name + "," + this.id + "," + this.contactInfo;
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

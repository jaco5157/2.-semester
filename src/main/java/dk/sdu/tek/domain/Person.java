package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;

public class Person implements Writeable{
    private String name;
    private int personID;
    private String contactInfo;

    public Person(String person, int personID, String contactInfo){
        this.name = person;
        this.personID = personID;
        this.contactInfo = contactInfo;
    }

    public String getPerson() {
        return name;
    }

    public void setPerson(String person) {
        this.name = person;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    @Override
    public String toString() {
        return this.name + "," + this.personID + "," + this.contactInfo;
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("people.txt", this);
    }
}

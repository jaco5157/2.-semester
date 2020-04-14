package dk.sdu.tek.domain;

import java.util.UUID;

public class Person {
    private String name;
    private String contactInfo;
    private UUID personID;


    public Person(String name, UUID personID, String contactInfo) {
        this.name = name;
        this.personID = personID;
        this.contactInfo = contactInfo;
    }

    public UUID getPersonID() {
        return personID;
    }

    public UUID setPersonID() {
        //this.personID = personID;
        personID = UUID.randomUUID();
        return personID;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

}
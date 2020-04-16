package dk.sdu.tek.domain;

public class Person {
    private String person;
    private int personID;
    private String contactInfo;

    public Person(String person, int personID, String contactInfo){
        this.person = person;
        this.personID = personID;
        this.contactInfo = contactInfo;
    }

    public String getPerson() {

        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
        System.out.println(person + personID + contactInfo);
        return null;
    }
}

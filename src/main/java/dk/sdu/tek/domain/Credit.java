package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;

public class Credit implements Writeable{
    private String role;
    private Person person;
    private Production production;

    public Credit (Person person, Production production, String role) {
        this.production = production;
        this.person = person;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Production getProduction() {
        return this.production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return this.person.getPersonID() + "," + this.production.getProductionID() + "," + this.role;
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("credits.txt", this);
    }
}

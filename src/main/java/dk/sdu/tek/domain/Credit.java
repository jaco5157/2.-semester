package dk.sdu.tek.domain;

import java.util.UUID;

public class Credit  {
    private String role;
    private Production production;
    private Person person;

    public Credit (Person person, String role, Production production){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}

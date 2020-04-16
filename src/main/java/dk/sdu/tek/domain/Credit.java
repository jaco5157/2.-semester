package dk.sdu.tek.domain;

public class Credit {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Credit (Person person, Production production, String role) {
        person.getPerson();

        this.role = role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}

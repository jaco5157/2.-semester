package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectWriter;
import dk.sdu.tek.presentation.AdminMenu;
import dk.sdu.tek.presentation.Menu;

public class Admin extends User {
    @Override
    public Menu getMenu() {
        return new AdminMenu();
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public void createProducer (String username, String password, int Production) {
        Producer producer = new Producer (username, password, Production);
        producer.write();
    }

    @Override
    public void write() {
        ObjectWriter.writeToFile("admins.txt", this);
    }

}

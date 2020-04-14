package dk.sdu.tek.domain;

public class Admin extends User{
    @Override
    public Menu getMenu() {
        return new AdminMenu();
    }
}

package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.AdminMenu;
import dk.sdu.tek.presentation.Menu;

public class Admin extends User{
    @Override
    public Menu getMenu() {
        return new AdminMenu();
    }
}

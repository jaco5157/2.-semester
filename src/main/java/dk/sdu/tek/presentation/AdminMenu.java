package dk.sdu.tek.presentation;

import java.io.IOException;

public class AdminMenu implements Menu {
    public static AdminMenu menu;

    @Override
    public void show() throws IOException {
        App.setRoot("adminmenu");
    }

    public static AdminMenu getMenu() {
        if (menu == null) {
            menu = new AdminMenu();
        }
        return menu;
    }
}

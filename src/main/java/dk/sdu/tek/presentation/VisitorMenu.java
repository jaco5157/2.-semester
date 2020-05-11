package dk.sdu.tek.presentation;

import java.io.IOException;

public class VisitorMenu implements Menu {
    private static VisitorMenu menu;

    @Override
    public void show() throws IOException {
        App.setRoot("VisitorMenu");
    }

    public static VisitorMenu getMenu() {
        if (menu == null) {
            menu = new VisitorMenu();
        }
        return menu;
    }
}

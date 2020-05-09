package dk.sdu.tek.presentation;

import java.io.IOException;

public class ProducerMenu implements Menu {
    private static ProducerMenu menu;

    @Override
    public void show() throws IOException {
        App.setRoot("producermenu");
    }

    public static ProducerMenu getMenu() {
        if (menu == null) {
            menu = new ProducerMenu();
        }
        return menu;
    }
}

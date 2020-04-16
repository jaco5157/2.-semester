package dk.sdu.tek.presentation;

import java.io.IOException;

public class VisitorMenu implements Menu {
    @Override
    public void show() throws IOException {
        App.setRoot("VisitorMenu");
    }

}

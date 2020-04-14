package dk.sdu.tek.presentation;

import dk.sdu.tek.presentation.App;
import dk.sdu.tek.presentation.Menu;

import java.io.IOException;

public class ProducerMenu implements Menu {
    @Override
    public void show() throws IOException {
        App.setRoot("producermenu");
    }
}

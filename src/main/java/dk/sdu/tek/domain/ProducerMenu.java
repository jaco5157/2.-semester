package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.App;

import java.io.IOException;

public class ProducerMenu implements Menu {
    @Override
    public void show() throws IOException {
        App.setRoot("producermenu");
    }
}

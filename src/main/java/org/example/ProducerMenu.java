package org.example;

import java.io.IOException;

public class ProducerMenu implements Menu {
    @Override
    public void show() throws IOException {
        App.setRoot("producermenu");
    }
}

package org.example;

import java.io.IOException;

public class Producer extends User {
    @Override
    public Menu getMenu() {
        return new ProducerMenu();
    }
}

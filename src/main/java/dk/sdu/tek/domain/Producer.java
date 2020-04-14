package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;
import dk.sdu.tek.presentation.ProducerMenu;

public class Producer extends User {
    @Override
    public Menu getMenu() {
        return new ProducerMenu();
    }
}

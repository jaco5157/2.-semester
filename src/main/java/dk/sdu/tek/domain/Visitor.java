package dk.sdu.tek.domain;

import dk.sdu.tek.presentation.Menu;
import dk.sdu.tek.presentation.VisitorMenu;

public class Visitor {

    public Visitor() {
    }

    public Menu getMenu() {
        return new VisitorMenu();
    }
}

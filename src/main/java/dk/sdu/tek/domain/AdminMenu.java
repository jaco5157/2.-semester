package dk.sdu.tek.domain;
import dk.sdu.tek.presentation.App;

import java.io.IOException;

public class AdminMenu implements Menu {
    @Override
    public void show() throws IOException {
        App.setRoot("adminmenu");
    }
}

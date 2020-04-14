package org.example;

import java.io.IOException;

public class Admin extends User{
    @Override
    public Menu getMenu() {
        return new AdminMenu();
    }
}

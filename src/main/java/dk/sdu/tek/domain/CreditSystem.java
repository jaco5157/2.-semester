package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;
import static dk.sdu.tek.persistence.ObjectReader.Type.ADMIN;
import static dk.sdu.tek.persistence.ObjectReader.Type.PRODUCER;
import java.util.ArrayList;

public class CreditSystem {
    private Visitor currentUser;

    public boolean authenticate(String username, String password, Boolean isAdmin) {
        ArrayList<User> userList;
        System.out.println("Is admin: " + isAdmin);
        if(isAdmin) {
            userList = ObjectReader.readObject(ADMIN);
        } else {
            userList = ObjectReader.readObject(PRODUCER);
        }
        System.out.println(userList);
        for (User user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public void setCurrentUser (Visitor currentUser) {
        this.currentUser = currentUser;
    }

    public Visitor getCurrentUser() {
        return currentUser;
    }

}

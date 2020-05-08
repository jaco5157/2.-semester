package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;

public class ObservableObject {
    private int id;
    private String object;
    private String type;

    public ObservableObject (int id, String object) {
        this.id = id;
        this.object = object;
    }

    public int getId() {
        return id;
    }
}

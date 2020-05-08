package dk.sdu.tek.domain;

public class ObservableObject {
    private int id;
    private String object;
    public enum Type {
        PRODUCTION,
        PERSON,
        PRODUCER,
        ADMIN,
        CREDIT
    }

    public ObservableObject (int id, String object, Type type) {
        this.id = id;
        this.object = object;
        this.type = type;
    }
}

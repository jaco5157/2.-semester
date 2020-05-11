package dk.sdu.tek.domain;

public class ObservableObject {
    private int id;
    private String name;
    private String object;

    public ObservableObject (int id, String name, String object) {
        this.id = id;
        this.name = name;
        this.object = object;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return this.name;
    }

    public String getObject(){
        return this.object;
    }

}

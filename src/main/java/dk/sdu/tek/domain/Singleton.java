package dk.sdu.tek.domain;

public class Singleton {

    private static CreditSystem instance = null;

    private Singleton() {}

    public static CreditSystem getInstance() {
        if (instance == null) {
            instance = new CreditSystem();
        }
        return instance;
    }
}

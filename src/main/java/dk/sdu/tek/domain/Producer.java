package dk.sdu.tek.domain;

public class Producer extends User {
    @Override
    public Menu getMenu() {
        return new ProducerMenu();
    }
}

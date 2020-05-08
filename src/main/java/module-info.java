module dk.sdu.tek {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;
    requires org.json;

    opens dk.sdu.tek.presentation to javafx.fxml;
    exports dk.sdu.tek.presentation;
}
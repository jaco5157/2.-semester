module dk.sdu.tek {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    exports dk.sdu.tek;
}
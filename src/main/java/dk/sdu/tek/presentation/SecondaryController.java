package dk.sdu.tek.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dk.sdu.tek.domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SecondaryController implements Initializable {

    @FXML private AnchorPane anchorpane;
    @FXML private ImageView logo;
    @FXML private ImageView exit;

    //Admin fields
    @FXML private TextField createProducerUsername;
    @FXML private TextField createProducerPassword;
    @FXML private TextField createProducerID;
    @FXML private Button adminCreateProducerButton;

    @FXML private TextField adminCreateProductionName;
    @FXML private TextField adminCreateProductionID;
    @FXML private TextField adminCreateProductionProdID;
    @FXML private Button adminCreateProductionButton;

    @FXML private TextField adminCreatePersonName;
    @FXML private TextField adminCreatePersonInfo;
    @FXML private TextField adminCreatePersonID;
    @FXML private Button createPersonButton;

    @FXML private TextField adminCreateCreditID;
    @FXML private TextField adminCreateCreditRole;
    @FXML private TextField adminCreateCreditProductionID;
    @FXML private Button adminCreateCreditButton;

    //Producer fields
    @FXML private TextField producerCreateProductionName;
    @FXML private TextField producerCreateProductionID;
    @FXML private TextField producerCreateProductionProdID;
    @FXML private Button producerCreateProductionButton;

    @FXML private TextField producerCreatePersonName;
    @FXML private TextField producerCreatePersonInfo;
    @FXML private TextField producerCreatePersonID;
    @FXML private Button producercreatePersonButton;

    @FXML private TextField producerCreateCreditID;
    @FXML private TextField producerCreateCreditRole;
    @FXML private TextField producerCreateCreditProductionID;
    @FXML private Button producerCreateCreditButton;

    private Stage stage;
    private double x = 0, y = 0;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void exit() {
        System.exit(1);
    }

    @FXML
    public void makeDragable() {
        anchorpane.setOnMousePressed(((mouseEvent) -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        }));

        anchorpane.setOnMouseDragged(((mouseEvent) -> {
            stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        }));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        makeDragable();
        App.setImageForImageView(logo,"Danish_TV_2_logo.png");
        App.setImageForImageView(exit, "red-x-mark.png");
    }

    public void adminCreateProducer(ActionEvent event) {
        Admin admin = (Admin)Singleton.getInstance().getCurrentUser();
        admin.createProducer(createProducerUsername.getText(),createProducerPassword.getText(),Integer.parseInt(createProducerID.getText()));
    }

    public void adminCreateProduction(ActionEvent event) {
        Admin admin = (Admin)Singleton.getInstance().getCurrentUser();
        admin.createProduction(adminCreateProductionName.getText(),Integer.parseInt(adminCreateProductionID.getText()),Integer.parseInt(adminCreateProductionProdID.getText()));
    }

    public void adminCreateCredit(ActionEvent event) {
        Admin admin = (Admin)Singleton.getInstance().getCurrentUser();
        admin.getProduction(Integer.parseInt(adminCreateCreditProductionID.getText())).addCredit(Integer.parseInt(adminCreateCreditID.getText()),adminCreateCreditRole.getText());
    }

    public void producerCreateProduction() {
        Producer producer = (Producer)Singleton.getInstance().getCurrentUser();
        producer.createProduction(producerCreateProductionName.getText(),Integer.parseInt(producerCreateProductionID.getText()));
    }

    public void producerCreateCredit(ActionEvent event) {
        Producer producer = (Producer)Singleton.getInstance().getCurrentUser();
        producer.getProduction(Integer.parseInt(adminCreateCreditProductionID.getText())).addCredit(Integer.parseInt(adminCreateCreditID.getText()),adminCreateCreditRole.getText());
    }

    public void createPerson(ActionEvent event) {
        User user = (User)Singleton.getInstance().getCurrentUser();
        user.createPerson(adminCreatePersonName.getText(),Integer.parseInt(adminCreatePersonID.getText()),adminCreatePersonInfo.getText());
    }
}
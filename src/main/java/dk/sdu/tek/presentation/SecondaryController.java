package dk.sdu.tek.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dk.sdu.tek.domain.Admin;
import dk.sdu.tek.domain.Producer;
import dk.sdu.tek.domain.Singleton;
import dk.sdu.tek.domain.Visitor;
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

    //Admin functionality
//    public void adminEventHandler (ActionEvent event) {
//        if (event.getSource() == adminCreateProducerButton) {
//
//        } else if (event.getSource() == adminCreateProductionButton) {
//
//        } else if (event.getSource() == createPersonButton) {
//
//        } else if (event.getSource() == adminCreateCreditButton) {
//
//        }
//    }

    public void adminCreateProducer() {
        Admin admin = (Admin)Singleton.getInstance().getCurrentUser();
        admin.createProducer(createProducerUsername.getText(),createProducerPassword.getText(),Integer.parseInt(createProducerID.getText()));
    }

    public void adminCreateProduction() {
        Admin admin = (Admin)Singleton.getInstance().getCurrentUser();
        admin.createProduction(adminCreateProductionName.getText(),Integer.parseInt(adminCreateProductionID.getText()),Integer.parseInt(adminCreateProductionProdID.getText()));
    }

    public void adminCreatePerson() {
        Admin admin = (Admin)Singleton.getInstance().getCurrentUser();
        admin.createPerson(adminCreatePersonName.getText(),Integer.parseInt(adminCreatePersonID.getText()),adminCreatePersonInfo.getText());
    }

    public void adminCreateCredit() {
        Admin admin = (Admin)Singleton.getInstance().getCurrentUser();
        admin.getProduction(Integer.parseInt(adminCreateCreditProductionID.getText())).addCredit(Integer.parseInt(adminCreateCreditID.getText()),adminCreateCreditRole.getText());

    }
}
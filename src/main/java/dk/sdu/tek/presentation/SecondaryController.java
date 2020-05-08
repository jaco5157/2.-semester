package dk.sdu.tek.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import dk.sdu.tek.domain.*;
import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SecondaryController implements Initializable {

    @FXML private ImageView logo;
    @FXML private ImageView exit;
    @FXML private AnchorPane wrapper;
    @FXML private TabPane mainTab;
    @FXML private TextField searchField;

    @FXML private ListView<ObservableObject> resultList;
    @FXML private TextField productionNameTextField;
    @FXML private TextField productionIDTextField;
    @FXML private TextField thisProducerTextField;
    @FXML private TextField thisProducerIDTextField;
    @FXML private ListView<ObservableObject> productionCreditList;

    //TextFields
    @FXML private TextField createProducerUsername;
    @FXML private TextField createProducerPassword;
    @FXML private TextField createProducerID;
    @FXML private Button adminCreateProducerButton;

    @FXML private TextField createProductionName;
    @FXML private TextField createProductionID;
    @FXML private TextField createProductionProdID;
    @FXML private Button adminCreateProductionButton;

    @FXML private TextField createPersonName;
    @FXML private TextField createPersonInfo;
    @FXML private TextField createPersonID;
    @FXML private Button createPersonButton;

    @FXML private TextField createCreditID;
    @FXML private TextField createCreditRole;
    @FXML private TextField createCreditProductionID;
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
    public void makeDraggable() {
        mainTab.setOnMousePressed(((mouseEvent) -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        }));

        mainTab.setOnMouseDragged(((mouseEvent) -> {
            stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        }));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        makeDraggable();
        App.setImageForImageView(logo,"Danish_TV_2_logo.png");
        App.setImageForImageView(exit, "red-x-mark.png");
        //setResultList();
    }

    public void setResultList () {
        ObservableList<Production> result = FXCollections.observableArrayList();
        for (Production production : CreditSystem.getInstance().getProductions()) {
            result.add(production);
        }
        resultList.setItems(result);
    }

    public void searchForProduction() {
        ArrayList<Production> productionArrayList = CreditSystem.getInstance().getProductions();
        for (Production production : productionArrayList) {
            if (productionArrayList.toString().contains(searchField.getText())) {
                resultList.getItems().add(production);
            }
        }
    }

    public void getSelectedItem () {
        Production selectedProduction = PersistenceHandler.getInstance().getProduction(resultList.getSelectionModel().getSelectedItem().getId());
        productionNameTextField.setText(selectedProduction.getName());
        productionIDTextField.setText(String.valueOf(selectedProduction.getId()));
        thisProducerTextField.setText(selectedProduction.getProducer().getUsername());
        thisProducerIDTextField.setText(String.valueOf(selectedProduction.getProducerID()));
        productionCreditList.setItems(result);
    }

    public void adminCreateProducer(ActionEvent event) {
        Admin admin = (Admin)CreditSystem.getInstance().getCurrentUser();
//        admin.createProducer(createProducerUsername.getText(),createProducerPassword.getText(),Integer.parseInt(createProducerID.getText()));
    }

    public void adminCreateProduction(ActionEvent event) {
        Admin admin = (Admin)CreditSystem.getInstance().getCurrentUser();
//        admin.createProduction(createProductionName.getText(),Integer.parseInt(createProductionID.getText()),Integer.parseInt(createProductionProdID.getText()));
    }

    public void adminCreateCredit(ActionEvent event) {
        Admin admin = (Admin)CreditSystem.getInstance().getCurrentUser();
//        admin.getOwnedProduction(Integer.parseInt(createCreditProductionID.getText())).addCredit(Integer.parseInt(createCreditID.getText()),createCreditRole.getText());
    }

    public void adminDeleteCredit(ActionEvent event) {
        Production selectedProduction = resultList.getSelectionModel().getSelectedItem();
        Credit selectedCredit = productionCreditList.getSelectionModel().getSelectedItem();
        if ((resultList.getSelectionModel().getSelectedItem() == selectedProduction) && (productionCreditList.getSelectionModel().getSelectedItem() == selectedCredit))
            productionCreditList.getItems().remove(selectedCredit);
        else if(resultList.getSelectionModel().getSelectedItem() == selectedProduction)
            resultList.getItems().remove(selectedProduction);
    }

    public void producerCreateProduction() {
        Producer producer = (Producer)CreditSystem.getInstance().getCurrentUser();
        producer.createProduction(createProductionName.getText(),Integer.parseInt(createProductionID.getText()));
    }

    public void producerCreateCredit(ActionEvent event) {
        Producer producer = (Producer)CreditSystem.getInstance().getCurrentUser();
//        producer.getOwnedProduction(Integer.parseInt(createCreditProductionID.getText())).addCredit(Integer.parseInt(createCreditID.getText()),createCreditRole.getText());
    }

    public void createPerson(ActionEvent event) {
        User user = (User)CreditSystem.getInstance().getCurrentUser();
        user.createPerson(createPersonName.getText(),Integer.parseInt(createPersonID.getText()),createPersonInfo.getText());
    }
}
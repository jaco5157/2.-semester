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
import javafx.stage.Stage;

public class SecondaryController implements Initializable {

    //FXML for search page
    @FXML private ImageView logo;
    @FXML private ImageView exit;
    @FXML private TabPane mainTab;
    @FXML private TextField searchField;
    @FXML private MenuButton selectItem;
    @FXML private ToggleGroup selectToggle;
    @FXML private RadioMenuItem selectProducers;
    @FXML private RadioMenuItem selectProductions;
    @FXML private RadioMenuItem selectCredits;
    @FXML private RadioMenuItem selectPeople;

    @FXML private ListView<ObservableObject> resultList;
    @FXML private TextArea infoArea;
    @FXML private Label creditLabel;
    @FXML private ListView<ObservableObject> creditList;

    //FXML for creating new objects
    @FXML private TextField createProducerUsername;
    @FXML private TextField createProducerPassword;
    @FXML private TextField createProducerId;

    @FXML private TextField createProductionName;
    @FXML private TextField createProductionId;
    @FXML private TextField createProductionProdId;

    @FXML private TextField createPersonName;
    @FXML private TextField createPersonInfo;
    @FXML private TextField createPersonId;

    @FXML private TextField createCreditId;
    @FXML private TextField createCreditPersonId;
    @FXML private TextField createCreditProductionId;
    @FXML private TextField createCreditRole;

    @FXML private Label successLabel;

    //FXML for editing credits
    @FXML private TextField editCreditSearch;
    @FXML private ListView<ObservableObject> resultCreditList;
    @FXML private TextField editCreditId;
    @FXML private TextField editCreditRole;
    @FXML private TextField editCreditPersonId;
    @FXML private TextField editCreditName;
    @FXML private TextField editCreditProdId;
    @FXML private TextField editCreditProdName;
    @FXML private Button deleteCredit;
    @FXML private Button editCredit;
    @FXML private Label editLabel;

    private Stage stage;
    private double x = 0, y = 0;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void exit() {
        System.exit(1);
    }

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
        setResultList();
        setCreditResultList();
    }

    public void setResultList () {
        creditLabel.setVisible(false);
        creditList.setVisible(false);
        if (selectProducers.isSelected()) {
            resultList.setItems(search(CreditSystem.getInstance().getProducers(), searchField.getText().toLowerCase()));
            selectItem.setText(selectProducers.getText());
        } else if (selectPeople.isSelected()) {
            creditLabel.setVisible(true);
            creditList.setVisible(true);
            resultList.setItems(search(CreditSystem.getInstance().getPeople(), searchField.getText().toLowerCase()));
            selectItem.setText(selectPeople.getText());
        } else if (selectCredits.isSelected()) {
            resultList.setItems(search(CreditSystem.getInstance().getCredits(), searchField.getText().toLowerCase()));
            selectItem.setText(selectCredits.getText());
        } else {
            creditLabel.setVisible(true);
            creditList.setVisible(true);
            resultList.setItems(search(CreditSystem.getInstance().getProductions(), searchField.getText().toLowerCase()));
            selectItem.setText(selectProductions.getText());
        }
    }

    public ObservableList<ObservableObject> search(ObservableList<ObservableObject> objects, String query) {
        ObservableList<ObservableObject> searchResults = FXCollections.observableArrayList();
        for (ObservableObject object : objects) {
            if (object.getObject().toLowerCase().contains(query)) {
                searchResults.add(object);
            }
        }
        return searchResults;
    }

    public void getSelectedItem () {
        ObservableObject selectedItem = resultList.getSelectionModel().getSelectedItem();
        infoArea.setText(selectedItem.getObject());
        if (selectToggle.getSelectedToggle() == selectProductions) {
            creditList.setItems(PersistenceHandler.getInstance().getProduction(selectedItem.getId()).getCredits());
        } else if (selectToggle.getSelectedToggle() == selectPeople) {
            creditList.setItems(PersistenceHandler.getInstance().getPerson(selectedItem.getId()).getCredits());
        }
    }

    //Create new objects
    public void createProducer() {
        printSuccess(CreditSystem.getInstance().createProducer(Integer.parseInt(createProducerId.getText()), createProducerUsername.getText(), createProducerPassword.getText()));
    }

    public void createProduction() {
        printSuccess(CreditSystem.getInstance().createProduction(Integer.parseInt(createProductionId.getText()), createProductionName.getText(), Integer.parseInt(createProductionProdId.getText())));
    }

    public void createPerson() {
        printSuccess(CreditSystem.getInstance().createPerson(Integer.parseInt(createPersonId.getText()), createPersonName.getText(), createPersonInfo.getText()));
    }

    public void createCredit() {
        printSuccess(CreditSystem.getInstance().createCredit(Integer.parseInt(createCreditId.getText()), Integer.parseInt(createCreditProductionId.getText()), Integer.parseInt(createCreditPersonId.getText()), createCreditRole.getText()));
    }

    public void printSuccess(boolean success) {
        if (success) {
            successLabel.setText("Succes! Objektet er nu oprettet");
        } else {
            successLabel.setText("Noget gik galt! Tjek om de angivne ID'er er unikke");
        }
    }

    //Edit credits
    public void setCreditResultList() {
        if (CreditSystem.getInstance().getIsAdmin()) {
            resultCreditList.setItems(search(PersistenceHandler.getInstance().getAdmin(CreditSystem.getInstance().getUserId()).getOwnedCredits(), searchField.getText().toLowerCase()));
        } else {
            resultCreditList.setItems(search(PersistenceHandler.getInstance().getProducer(CreditSystem.getInstance().getUserId()).getOwnedCredits(), searchField.getText().toLowerCase()));
        }
    }

    public void getSelectedCredit () {
        Credit selectedCredit = PersistenceHandler.getInstance().getCredit(resultCreditList.getSelectionModel().getSelectedItem().getId());
        editCreditId.setText(String.valueOf(selectedCredit.getId()));
        editCreditRole.setText(selectedCredit.getRole());
        editCreditPersonId.setText(String.valueOf(selectedCredit.getPersonID()));
        editCreditName.setText(PersistenceHandler.getInstance().getPerson(selectedCredit.getPersonID()).getName());
        editCreditProdId.setText(String.valueOf(selectedCredit.getProductionID()));
        editCreditProdName.setText(PersistenceHandler.getInstance().getProduction(selectedCredit.getProductionID()).getName());
    }

    public void deleteCredit() {
        if(PersistenceHandler.getInstance().deleteCredit(resultCreditList.getSelectionModel().getSelectedItem().getId())) {
            editLabel.setText("Succes! Kreditering er slettet");
            setCreditResultList();
        } else {
            editLabel.setText("Noget gik galt");
        }
    }

    public void editCredit() {

    }
}
package dk.sdu.tek.presentation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dk.sdu.tek.domain.*;
import dk.sdu.tek.persistence.PersistenceHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {

    @FXML private Label errorlabel;
    @FXML private AnchorPane anchorpane;
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private RadioButton adminbutton;
    @FXML private ImageView largeLogo;
    @FXML private ImageView smallLogo;
    @FXML private ImageView exit;
    @FXML private Button visitorloginbutton;

    private Stage stage;
    private double x = 0, y = 0;
<<<<<<< Updated upstream
    private Admin admin = null;
    private Producer producer = null;
    private Visitor visitor = null;

    @FXML
    public void Login(ActionEvent actionEvent) throws IOException {
        try {
            if (adminbutton.isSelected() && CreditSystem.getInstance().authenticate(username.getText(), password.getText(), adminbutton.isSelected())) {
                admin = (Admin)CreditSystem.getInstance().getCurrentUser();
                AdminMenu menu = (AdminMenu)admin.getMenu();
                menu.show();
            } else if(!adminbutton.isSelected() && CreditSystem.getInstance().authenticate(username.getText(), password.getText())) {
                producer = (Producer) CreditSystem.getInstance().getCurrentUser();
                ProducerMenu menu = (ProducerMenu)producer.getMenu();
                menu.show();
            }
            else {
                errorlabel.setText("Login Error");
            }
        }
        catch (ClassCastException ex) {
=======
    private boolean isAdmin = false;
    private int userId;

    @FXML
    public void Login(ActionEvent actionEvent) throws IOException {
        boolean hasCredentials = CreditSystem.getInstance().authenticate(username.getText(), password.getText(), adminbutton.isSelected());
        if (isAdmin && hasCredentials) {
            isAdmin = adminbutton.isSelected();
            userId = PersistenceHandler.getInstance().getAdmin(username.getText()).getId();
            AdminMenu.getMenu().show();
        } else if (!isAdmin && hasCredentials) {
            userId = PersistenceHandler.getInstance().getProducer(username.getText()).getId();
            ProducerMenu.getMenu().show();
        } else {
>>>>>>> Stashed changes
            errorlabel.setText("Login Error");
        }

    }

    @FXML
    public void visitorLogin(ActionEvent actionEvent) throws IOException {
        visitor = new Visitor();

        CreditSystem.getInstance().setCurrentUser(visitor);
        VisitorMenu menu = (VisitorMenu)visitor.getMenu();
        menu.show();
    }

    @FXML
    public void exit() {
        System.exit(1);
    }

    @FXML
    public void makeDraggable() {
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
        makeDraggable();
        App.setImageForImageView(largeLogo,"TV2_Denmark_logo_2017.png");
        App.setImageForImageView(smallLogo,"Danish_TV_2_logo.png");
        App.setImageForImageView(exit, "red-x-mark.png");
    }

    protected boolean isAdmin() {
        return isAdmin;
    }

}

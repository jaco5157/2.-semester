package dk.sdu.tek.presentation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dk.sdu.tek.domain.Admin;
import dk.sdu.tek.domain.Producer;
import dk.sdu.tek.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private Stage stage;
    private double x = 0, y = 0;

    @FXML
    public void Login(ActionEvent actionEvent) throws IOException {
        User user = new User();
        Admin admin = new Admin();
        Producer producer = new Producer();

            if (user.authenticate(username, password) && adminbutton.isSelected() && username.getText().equals("admin")) {
                admin.getMenu().show();
            } else if(user.authenticate(username, password) && !adminbutton.isSelected() && !username.getText().equals("admin")) {
                producer.getMenu().show();
            }
            else {
            errorlabel.setText("Login Error");
            }
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
        setImageForImageView(largeLogo,"TV2_Denmark_logo_2017.png");
        setImageForImageView(smallLogo,"Danish_TV_2_logo.png");
        setImageForImageView(exit, "red-x-mark.png");
    }

    private void setImageForImageView(ImageView view, String s) {
        Image i = new Image(getClass().getResourceAsStream(s));
        view.setImage(i);
    }
}

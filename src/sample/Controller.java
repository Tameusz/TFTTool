package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button start;

    @FXML
    private Button aboutGame;

    @FXML
    private Button aboutApp;

    @FXML
    private Button exit;

    @FXML
    private Button returnButton;

    @FXML
    private ImageView textField;

    @FXML
    private Text aboutText;

    private Scene mainScene;


    @FXML
    void onActionAboutApp(ActionEvent event) {
        if (textField.isVisible() == false && aboutText.isVisible() == false) {
            textField.setVisible(true);
            aboutText.setVisible(true);
            aboutText.setText("asadsa");
        } else {
            textField.setVisible(false);
            aboutText.setVisible(false);
        }
    }

    @FXML
    void onActionAboutGame(ActionEvent event) {
        if(textField.isVisible() == false && aboutText.isVisible() == false) {
            textField.setVisible(true);
            aboutText.setVisible(true);
            aboutText.setText("asdasdsadadsa");
        } else {
            textField.setVisible(false);
            aboutText.setVisible(false);
        }
    }

    @FXML
    void onActionStart(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            //main.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void onActionReturn(ActionEvent event) {
        //TODO no zrobić coś
        // Champion aatrox = new Champion();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            //main.stg.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

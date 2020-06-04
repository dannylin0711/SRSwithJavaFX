package srs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainmenuController implements Initializable {
    @FXML Button logoutButton;
    @FXML Button queryClassButton;
    @FXML Button querySchedule;
    @FXML Button selectClassButton;
    @FXML Button addClassButton;
    @FXML Button listStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switch (LoginController.accountOwnerName.getType()){
            case student:
                addClassButton.setDisable(true);
                listStudent.setDisable(true);
                queryClassButton.setDisable(false);
                querySchedule.setDisable(false);
                selectClassButton.setDisable(false);
                break;
            case teacher:
                queryClassButton.setDisable(true);
                selectClassButton.setDisable(true);
                addClassButton.setDisable(false);
                listStudent.setDisable(false);
                querySchedule.setDisable(false);
                break;
        }
    }

    @FXML
    void logout(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/srs/controller/LoginControllerScene.fxml"));
        currentStage.setScene(new Scene(root,300,300));
        currentStage.setTitle("課程系統 V1.0");
    }

    @FXML
    void queryClassButtonClicked(ActionEvent actionEvent) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/srs/controller/ClassViewerScene.fxml"));
        stage.setTitle("課程查詢");
        stage.setScene(new Scene(root, 667, 400));
        stage.show();
    }


}

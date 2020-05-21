package srs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainmenuController {
    @FXML Button logoutButton;
    @FXML
    void logout(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/srs/controller/LoginControllerScene.fxml"));
        currentStage.setScene(new Scene(root,300,300));
        currentStage.setTitle("課程系統 V1.0");
    }
}

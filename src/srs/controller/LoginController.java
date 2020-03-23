package srs.controller;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import srs.SQLConnecter;
import srs.model.AccountLoggedIn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;




public class LoginController implements Initializable {
    @FXML TextField accountTextField;
    @FXML PasswordField passwordTextField;
    @FXML Button loginButton;
    @FXML Button resetPasswordButton;

    private AccountLoggedIn accountOwnerName = new AccountLoggedIn("");

    @FXML
    void loginClicked(ActionEvent e){
        String account = accountTextField.getText();
        String password = passwordTextField.getText();
        boolean loginToken = SQLConnecter.loginSession(account,password,accountOwnerName);
        if(account.equals("") || password.equals("")){
            loginToken = false;
        }
        if (loginToken){
            try {
                loginSession(e);

            }catch (IOException ioException){
                System.out.println(ioException.getMessage());
            }

        }else{
            loginFailed();
        }
    }
    @FXML
    void loginClicked(KeyEvent e){
        String account = accountTextField.getText();
        String password = passwordTextField.getText();
        boolean loginToken = SQLConnecter.loginSession(account,password,accountOwnerName);
        if(account.equals("") || password.equals("")){
            loginToken = false;
        }
        if (loginToken){
            try {
                loginSession(e);
            }catch (IOException ioException){
                System.out.println(ioException.getMessage());
            }

        }else{
            loginFailed();
        }
    }

    private void loginSession(Event e) throws IOException {
        System.out.println("Success");
        System.out.println(accountOwnerName.getName());
        Stage currentStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/srs/controller/MainmenuScene.fxml"));
        currentStage.setScene(new Scene(root,300,300));
        currentStage.setTitle("課程系統 V1.0 登入者:"+accountOwnerName.getName());

    }

    private void loginFailed(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("登入錯誤");
        alert.setTitle("登入錯誤");
        alert.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

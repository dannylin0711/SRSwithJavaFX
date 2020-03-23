package srs.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import srs.model.Course;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassViewerController implements Initializable {
    @FXML ComboBox<String> searchTypeSelectComboBox;
    @FXML TableView<Course> courseTableView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchTypeSelectComboBox.getItems().addAll(
                "課程ID",
                "課程名稱",
                "教授名稱"
        );
    }
}

package srs.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import srs.SQLConnecter;
import srs.model.Course;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassViewerController implements Initializable {
    @FXML Button reloadButton;
    @FXML Button closeButton;
    @FXML Button searchButton;
    @FXML ComboBox<String> searchTypeSelectComboBox;
    @FXML TableView<Course> courseTableView;
    @FXML TableColumn<Course, Integer> courseIDTableColumn;
    @FXML TableColumn<Course, String> courseNameTableColumn;
    @FXML TableColumn<Course, Integer> courseLecturerTableColumn;
    @FXML TableColumn<Course, Integer> coursePeriodTableColumn;
    @FXML TableColumn<Course, Integer> courseLengthTableColumn;
    @FXML TableColumn<Course, String> courseWeekdayTableColumn;
    @FXML TextField searchTextField;


    ObservableList<Course> courseObservableList;
    FilteredList<Course> courseFilteredList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchTypeSelectComboBox.getItems().addAll(
                "課程ID",
                "課程名稱",
                "教授名稱"
        );
        courseTableView.setPlaceholder(new Label("無課程資訊"));
        getData();
    }

    @FXML
    void reloadData(ActionEvent e){
        getData();
    }

    @FXML
    void closeStage(){
        Stage tempstage = (Stage)closeButton.getScene().getWindow();
        tempstage.close();

    }

    @FXML
    void search(){
        String searchString = searchTextField.getText();
        String tempTest = searchTypeSelectComboBox.getValue();
        switch (tempTest){
            case "課程ID":
                courseFilteredList.setPredicate(data -> {
                    if(searchString.equals("")){
                        return true;
                    }
                    if(data.getId().get() == Integer.parseInt(searchString)){
                        return true;
                    }
                    return false;
                });
                break;
            case "課程名稱":
                courseFilteredList.setPredicate(data -> {
                    if(searchString.equals("")){
                        return true;
                    }
                    if(data.getCourseName().get().equals(searchString)){
                        return true;
                    }
                    return false;
                });
                break;
            default:
                break;
        }
        SortedList<Course> sortedData = new SortedList<>(courseFilteredList);
        sortedData.comparatorProperty().bind(courseTableView.comparatorProperty());
        courseTableView.setItems(sortedData);
    }

    private void getData(){
        courseObservableList = SQLConnecter.getCourse();
        courseFilteredList = new FilteredList<>(courseObservableList,p->true);
        courseTableView.setItems(courseFilteredList);
        courseIDTableColumn.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        courseNameTableColumn.setCellValueFactory(cellData -> cellData.getValue().getCourseName());
        courseLecturerTableColumn.setCellValueFactory(cellData -> cellData.getValue().getLecturer().asObject());
        courseWeekdayTableColumn.setCellValueFactory(cellData -> cellData.getValue().getWeekday());
        coursePeriodTableColumn.setCellValueFactory(cellData -> cellData.getValue().getPeriod().asObject());
        courseLengthTableColumn.setCellValueFactory(cellData -> cellData.getValue().getPeriodLength().asObject());
    }

}

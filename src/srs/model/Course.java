package srs.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import srs.SQLConnecter;

public class Course {
    private IntegerProperty id;
    private StringProperty courseName,lecturerString;
    private IntegerProperty weekday,period,periodLength,lecturer;

    Course(){
        id = new SimpleIntegerProperty(0);
        courseName = new SimpleStringProperty("");
        lecturer = new SimpleIntegerProperty(0);
        weekday = new SimpleIntegerProperty(0);
        period = new SimpleIntegerProperty(0);
        periodLength = new SimpleIntegerProperty(0);
        lecturerString = new SimpleStringProperty("");
    }

    public Course(int id, String courseName, int lecturer, int weekday, int period, int periodLength){
        this.id = new SimpleIntegerProperty(id);
        this.courseName = new SimpleStringProperty(courseName);
        this.lecturer = new SimpleIntegerProperty(lecturer);
        this.weekday = new SimpleIntegerProperty(weekday);
        this.period = new SimpleIntegerProperty(period);
        this.periodLength = new SimpleIntegerProperty(periodLength);
        this.lecturerString = new SimpleStringProperty("");
    }

    public StringProperty getCourseName(){
        return courseName;
    }

    public IntegerProperty getLecturer(){
        return lecturer;
    }

    public IntegerProperty getId(){
        return id;
    }

    public StringProperty getWeekday(){
        StringProperty tempWeekdayStringProperty = new SimpleStringProperty("未設定");
        switch (this.weekday.get()){
            case 1:
                tempWeekdayStringProperty = new SimpleStringProperty("一");
                break;
            case 2:
                tempWeekdayStringProperty = new SimpleStringProperty("二");
                break;
            case 3:
                tempWeekdayStringProperty = new SimpleStringProperty("三");
                break;
            case 4:
                tempWeekdayStringProperty = new SimpleStringProperty("四");
                break;
            case 5:
                tempWeekdayStringProperty = new SimpleStringProperty("五");
                break;
        }
        return tempWeekdayStringProperty;
    }

    public IntegerProperty getPeriod(){
        return period;
    }

    public IntegerProperty getPeriodLength(){
        return periodLength;
    }

    public void updateLecturerStringInfo(){
//        SQLConnecter.update
    }
}

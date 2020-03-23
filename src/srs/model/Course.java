package srs.model;

public class Course {
    private int id;
    private String courseName,lecturer;
    private int weekday,period,periodLength;

    Course(){
        id = 0;
        courseName = "";
        lecturer = "";
        weekday = 0;
        period = 0;
        periodLength = 0;
    }

    Course(int id,String courseName,String lecturer,int weekday,int period,int periodLength){
        this.id = id;
        this.courseName = courseName;
        this.lecturer = lecturer;
        this.weekday = weekday;
        this.period = period;
        this.periodLength = periodLength;
    }

    String getCourseName(){
        return courseName;
    }

    String getLecturer(){
        return lecturer;
    }

    int getId(){
        return id;
    }

    int getWeekday(){
        return weekday;
    }

    int getPeriod(){
        return period;
    }

    int getPeriodLength(){
        return periodLength;
    }
}

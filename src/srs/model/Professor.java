package srs.model;

public class Professor extends People {
    Professor(){
        this.type = UserType.teacher;
    }
    public Professor(String name){
        this.name = name;
        this.type = UserType.teacher;
    }
    void addClass(int id,String courseName,int weekday,int startPeriod,int length){

    }

    void deleteClass(int id){

    }

}

package srs.model;

public class Student extends People {
    public Student(){
        this.type = UserType.student;
    }
    public Student(String name){
        this.name = name;
        this.type = UserType.student;
    }
}

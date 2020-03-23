package srs.model;

enum UserType{
    student,
    teacher,
    administrator
}

public abstract class People {
    int id;
    String name,uid;
    UserType type;
}

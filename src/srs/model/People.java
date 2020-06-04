package srs.model;

public abstract class People {
    int id;
    String name,uid;
    UserType type;

    public String getName(){
        return name;
    }

    public UserType getType(){
        return type;
    }

}

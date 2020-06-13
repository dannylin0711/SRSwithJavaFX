package srs.model;

public abstract class People {
    int id;
    String name,uid;
    UserType type;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public UserType getType(){
        return type;
    }

    public String getUid() {
        return uid;
    }

    public int getId() {
        return id;
    }
}

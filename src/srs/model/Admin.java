package srs.model;

public class Admin extends People {
    Admin(){
        this.type = UserType.administrator;
    }
    public Admin(String name){
        this.name = name;
        this.type = UserType.administrator;
    }
}

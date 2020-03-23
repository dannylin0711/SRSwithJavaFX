package srs.model;

public class AccountLoggedIn {
    String name;
    public AccountLoggedIn(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

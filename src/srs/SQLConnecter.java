package srs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import srs.controller.LoginController;
import srs.model.*;

import java.sql.*;

public class SQLConnecter {
    private static String sqlServerURL = "127.0.0.1";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSets;
    private static void setConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Account?useUnicode=true&characterEncoding=UTF-8",
                    "user","qwertyui0987");
            statement = connection.createStatement();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }
    private static void setConnection(String schema){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/"+schema+"?useUnicode=true&characterEncoding=UTF-8",
                    "user","qwertyui0987");
            statement = connection.createStatement();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }


    public static Boolean loginSession(String accountName, String accountPassword){
        setConnection();
        String tempAcc,tempPwd;
        try {
            String query="select * from Account\n"+ "Where ID ='" +accountName+"'";
            statement.executeQuery(query);
            resultSets = statement.getResultSet();
            if(resultSets.next()) {
                tempAcc = resultSets.getString("ID");
                tempPwd = resultSets.getString("Password");
                int currentUserType = resultSets.getInt("identity");
                String name = resultSets.getString("name");
                switch (currentUserType){
                    case 0:
                        LoginController.accountOwnerName = new Student(name);
                        break;
                    case 1:
                        LoginController.accountOwnerName = new Professor(name);
                        break;
                    case 2:
                        LoginController.accountOwnerName = new Admin(name);
                        break;
                }
                //ownerName.setName(resultSets.getString("name"));
                //tempIdentify = resultSets.getInt("identity");
            }else{
                tempAcc = "";
                tempPwd = "";

            }


            if(tempAcc.equals(accountName)&&tempPwd.equals(accountPassword)) {
                return true;
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());

        }
        return false;
    }

    public static ResultSet searchSchedule(String Account) {
        setConnection("Schedule");
        try {
            String query = "Select * from "+Account;
            statement.executeQuery(query);
            resultSets = statement.getResultSet();

        }catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("You may not have select any class or database error occured\nPlease check again or contact system administator.");
        }
        return resultSets;

    }

    public static ObservableList<Course> getCourse(){
        ObservableList<Course> courseObservableList = FXCollections.observableArrayList();
        setConnection("ClassInf");
        try {
            String query = "select * from Course\n";
            statement.executeQuery(query);
            resultSets =statement.getResultSet();
            while(resultSets.next()){
                Course tempCourse;
                int tempID,weekday,period,length,teacherID,maxStu,minStu,joinedStu;
                String courseName;
                courseName = resultSets.getString("courseName");
                tempID = resultSets.getInt("idCourse");
                weekday = resultSets.getInt("weekday");
                period = resultSets.getInt("period");
                length = resultSets.getInt("length");
                teacherID = resultSets.getInt("teacherID");
                maxStu = resultSets.getInt("maxStu");
                minStu = resultSets.getInt("minStu");
                joinedStu = resultSets.getInt("joinedStu");
                tempCourse = new Course(tempID,courseName,teacherID,weekday,period,length);
                courseObservableList.add(tempCourse);
            }

            //System.out.println(forRe);
        }catch(Exception ex) {
            //System.out.println(ex);
            ex.printStackTrace();
        }
        return courseObservableList;
    }
    public static String returnClassName(int a) {
        String forRe = "";
        try
        {
            String query = "select * from Course\n where idCourse ="+a;
            statement.executeQuery(query);
            resultSets =statement.getResultSet();
            resultSets.next();
            forRe = resultSets.getString("Name");
            //System.out.println(forRe);
        }catch(Exception ex) {
            //System.out.println(ex);
            ex.printStackTrace();
        }
        return forRe;
    }
    public static void addSchedule(int a) {

    }
    public static ResultSet searchClass(String a) {
        try {
            String query  ="Select * from Course where Name ='"+a+"'";
            statement.executeQuery(query);
            resultSets =statement.getResultSet();
        }catch(Exception x) {
            x.printStackTrace();
        }
        return resultSets;
    }
    public static boolean checkSelected(int a,String b) {
        String query ="Select * from "+b+" Where selectedID="+a;
        try {
            statement.executeQuery(query);
            resultSets = statement.getResultSet();
            if(resultSets.next()) {
                return true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}

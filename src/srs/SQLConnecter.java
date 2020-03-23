package srs;

import srs.model.AccountLoggedIn;

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
            //取得connection
            statement = connection.createStatement();
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }

    private static void checkStatementAvailability(){
        if (statement == null){
            setConnection();
        }
    }

    public static Boolean loginSession(String accountName, String accountPassword, AccountLoggedIn ownerName){
        checkStatementAvailability();
        String tempacc,temppwd;
        try {
            String query="select * from Account\n"+ "Where ID ='" +accountName+"'";
            statement.executeQuery(query);
            resultSets = statement.getResultSet();
            if(resultSets.next()) {
                tempacc = resultSets.getString("ID");
                temppwd = resultSets.getString("Password");
                ownerName.setName(resultSets.getString("name"));
                //tempidentify = resultSets.getInt("identity");
            }else{
                tempacc = "";
                temppwd = "";

            }


            if(tempacc.equals(accountName)&&temppwd.equals(accountPassword)) {
                return true;
            }
        }catch(Exception ex) {
            System.out.println(ex);

        }
        return false;
    }
}

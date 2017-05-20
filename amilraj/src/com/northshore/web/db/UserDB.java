package com.northshore.web.db;

import java.sql.*;

/**
 * Created by 170101022 on 5/20/2017.
 */
public class UserDB {
    private Connection connect;
    private ResultSet resulset = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public void readDatabase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/AIRPORT_SYS?" + "user=root");
            statement = connect.createStatement();
            resulset = statement.executeQuery("SELECT * FROM USERDETAIL ");
            writeResultset(resulset);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* public static void main (String[] args) throws Exception {
         UserDB access =new UserDB();
         access.readDatabase();*/
    private void writeResultset(ResultSet resultset) throws SQLException {
        while (resultset.next()) {
            int ID = resultset.getInt("ID");
            String UserName = resultset.getString("UserName");
            String password = resultset.getString("password");
            String FirstName = resultset.getString("FirstName");
            String LastName = resultset.getString("lastName");
            System.out.println(UserName);
            System.out.println(password);
            System.out.println(FirstName);
            System.out.println(LastName);



        }


    }

    public static void main(String[] args) throws Exception {
        UserDB user = new UserDB();
        user.readDatabase();
    }

}


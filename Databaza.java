package sample.sems;

import java.sql.*;

public class Databaza {
    private static Connection dbConnection;

    private final static String host = "localhost";
    private final static String dbName = "DBKNK";
    private final static String username = "root";
    private final static String password = "root";

    public static Connection getConnection() {
        if(dbConnection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                dbConnection = DriverManager.getConnection("jdbc:mysql://" + host+ "/" + dbName, username, password);

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        return dbConnection;
    }
}
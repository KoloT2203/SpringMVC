package ru.kolotov.springMvc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2203";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

}

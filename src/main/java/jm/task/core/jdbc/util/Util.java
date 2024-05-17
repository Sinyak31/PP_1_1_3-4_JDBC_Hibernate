package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:MySql://localhost:3306/my";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "234065";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("no such db");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("no JDBC driver");
            throw new RuntimeException(e);
        }
        return connection;
    }

}

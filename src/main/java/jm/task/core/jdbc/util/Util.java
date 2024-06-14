package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {


    private Connection connection = null;

    public Util() {
        final String URL = "jdbc:mysql://localhost:3306/users";
        final String DB_USER = "root";
        final String DB_PASSWORD = "root";

        try {
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}




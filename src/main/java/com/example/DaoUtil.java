package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoUtil {
    private static DaoUtil instance;
    private Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5433/daotest";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    private DaoUtil() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver not found", e);
        }
    }

    public static  DaoUtil getInstance() throws SQLException {
        if (instance == null) {
            instance = new DaoUtil();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    

    // public void closeConnection() {
    //     if (connection != null) {
    //         try {
    //             connection.close();
    //         } catch (SQLException e) {
    //             System.err.println("Error closing connection: " + e.getMessage());
    //         }
    //     }
    // }
}

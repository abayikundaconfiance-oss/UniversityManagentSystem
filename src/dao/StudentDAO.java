package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/UniversityManagementDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "confi@12";

    public static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(
                    URL, USER, PASSWORD
            );

            System.out.println("Database connected successfully!");

            return connection;

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}

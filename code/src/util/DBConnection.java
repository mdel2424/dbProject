package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        try {
            // Establishes connection to Postgres DB, which will be used in the dao classes
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/dbProject";
            String user = "postgres";
            String password = "admin";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

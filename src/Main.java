package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db"; // Adjust path if needed
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the SQLite database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String createProductTableSQL = "CREATE TABLE IF NOT EXISTS product (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "description TEXT," +
                "price DECIMAL NOT NULL" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            stmt.execute(createProductTableSQL); // Execute the CREATE TABLE SQL
            System.out.println("Table created or already exists.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
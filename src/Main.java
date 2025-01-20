package src;

import java.sql.Connection;
import java.sql.DriverManager;

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
    }
}
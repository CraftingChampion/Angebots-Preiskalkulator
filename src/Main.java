package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:sqlite:database.db"; // Adjust path if needed
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the SQLite database.");

                // Create table if not exists (product)
                String createProductTableSQL = "CREATE TABLE IF NOT EXISTS product (" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "description TEXT," +
                        "price DECIMAL NOT NULL" +
                        ");";

                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createProductTableSQL); // Execute the CREATE TABLE SQL
                    System.out.println("Table created or already exists.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(
                "Your options: 1. Add product, 2. Edit product 3. Delete product 4. List products with all details 5. Exit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Add product");
                break;
            case 2:
                System.out.println("Edit product");
                break;
            case 3:
                System.out.println("Delete product");
                break;
            case 4:
                System.out.println("List products with all details");
                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }
}
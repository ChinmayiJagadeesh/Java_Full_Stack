/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.sql.*;
public class FoodDelivarySystem {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/FoodDeliverySystem";
        String user = "root";
        String password = "root";   // change if your MySQL password is different

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // Create Customers Table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Customers(" +
                    "customer_id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "city VARCHAR(50)," +
                    "phone VARCHAR(15))");

            // Create Restaurants Table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Restaurants(" +
                    "restaurant_id INT PRIMARY KEY," +
                    "restaurant_name VARCHAR(50)," +
                    "city VARCHAR(50)," +
                    "rating DECIMAL(2,1))");

            // Create Food Items Table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Food_Items(" +
                    "food_id INT PRIMARY KEY," +
                    "food_name VARCHAR(50)," +
                    "price INT," +
                    "restaurant_id INT)");

            // Create Orders Table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Orders(" +
                    "order_id INT PRIMARY KEY," +
                    "customer_id INT," +
                    "food_id INT," +
                    "quantity INT," +
                    "order_date DATE)");

            // Insert Data (IGNORE prevents duplicate errors)
            stmt.executeUpdate("INSERT IGNORE INTO Customers VALUES(1,'Anita','Bangalore','9876543210')");
            stmt.executeUpdate("INSERT IGNORE INTO Customers VALUES(2,'Arjun','Chennai','9123456780')");

            stmt.executeUpdate("INSERT IGNORE INTO Restaurants VALUES(1,'Dominos','Bangalore',4.5)");
            stmt.executeUpdate("INSERT IGNORE INTO Restaurants VALUES(2,'Pizza Hut','Chennai',4.2)");

            stmt.executeUpdate("INSERT IGNORE INTO Food_Items VALUES(101,'Veg Pizza',250,1)");
            stmt.executeUpdate("INSERT IGNORE INTO Food_Items VALUES(102,'Chicken Pizza',320,2)");
            stmt.executeUpdate("INSERT IGNORE INTO Food_Items VALUES(103,'Burger',150,1)");

            stmt.executeUpdate("INSERT IGNORE INTO Orders VALUES(1,1,101,2,'2026-03-01')");

            // SELECT Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Food_Items");

            System.out.println("Food Items List:");

            while(rs.next()) {
                System.out.println(
                        rs.getInt("food_id") + " " +
                        rs.getString("food_name") + " " +
                        rs.getInt("price"));
            }

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}



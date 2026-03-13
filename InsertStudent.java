/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.sql.*;
import java.util.Scanner;
public class InsertStudent {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/SKIT",
                "root",
                "Root@123"
            );

            String query = "INSERT INTO Students VALUES(?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, 4);
            ps.setString(2, "Anu");
            ps.setString(3, "ECE");

            ps.executeUpdate();

            System.out.println("Data inserted successfully");

            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

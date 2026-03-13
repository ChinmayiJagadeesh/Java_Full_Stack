/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.sql.*;
public class ScholorshipViewDemo {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/UniversityDataBase",
                    "root",
                    "Root@123");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM eligible_scholarship_students");

            System.out.println("Eligible Students for Scholarship:");

            while(rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("department") + " " +
                        rs.getInt("marks") + " " +
                        rs.getInt("attendance"));
            }

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}


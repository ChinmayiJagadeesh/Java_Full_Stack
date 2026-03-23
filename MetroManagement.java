/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
 import java.sql.*;
public class MetroManagement {
 public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/MetroDatabase",
                    "root",
                    "root");// change if your MySQL password is different

            Statement st = con.createStatement();

            // Insert station
            st.executeUpdate("INSERT INTO Stations VALUES (6,'KR Puram','Bangalore',3,2020)");

            // Insert train
            st.executeUpdate("INSERT INTO Trains VALUES (104,'Blue Line',950,1)");

            // Update train capacity
            st.executeUpdate("UPDATE Trains SET capacity=1100 WHERE train_id=104");

            // Delete station
            st.executeUpdate("DELETE FROM Stations WHERE station_id=4");

            // Display Stations
            ResultSet rs = st.executeQuery("SELECT * FROM Stations");

            System.out.println("Stations Table");
            while(rs.next()) {
                System.out.println(
                        rs.getInt("station_id") + " " +
                        rs.getString("station_name") + " " +
                        rs.getString("location") + " " +
                        rs.getInt("platforms") + " " +
                        rs.getInt("opening_year")
                );
            }

            // Display Trains
            rs = st.executeQuery("SELECT * FROM Trains");

            System.out.println("\nTrains Table");
            while(rs.next()) {
                System.out.println(
                        rs.getInt("train_id") + " " +
                        rs.getString("train_name") + " " +
                        rs.getInt("capacity") + " " +
                        rs.getInt("station_id")
                );
            }

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.sql.*;
public class HospitalAppointement {
    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/HospitalDB",
            "root",
            "root");

            CallableStatement cs = con.prepareCall("{call book_appointment(?,?,?)}");

            cs.setInt(1,3);
            cs.setInt(2,1);
            cs.setDate(3,Date.valueOf("2026-03-15"));

            ResultSet rs = cs.executeQuery();

            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}


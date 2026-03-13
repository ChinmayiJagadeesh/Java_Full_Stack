/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;
public class PoolDemo {
    public static void main(String[] args) {

        HikariDataSource ds = null;

        try {
            // Step 1: Configure pool
            HikariConfig config = new HikariConfig();

            config.setJdbcUrl("jdbc:mysql://localhost:3306/college");
            config.setUsername("root");
            config.setPassword("Root@123");

            // Step 2: Pool settings
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            config.setConnectionTimeout(30000);

            // Step 3: Create pool
            ds = new HikariDataSource(config);

            // Step 4: Get connection
            Connection con = ds.getConnection();

            // Step 5: Execute query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Stu");

            // Step 6: Display data
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch"));
            }

            // Step 7: Return connection to pool
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close pool
            if (ds != null) {
                ds.close();
            }
        }
    }
}

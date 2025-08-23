package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

public class CustomerJdbc {
    static final String DB_URL = "jdbc:mysql://localhost:3306/javacore72022";
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args) {
        // Input:
       
        String fullName = null;
        
        ResultSet rs = null;
        Connection conn = null; 
        Statement stmt = null;
        try {
            String sql = "select * from customer "+SystemConstant.ONE_EQUAL_ONE+"";
          
            if (!StringUtils.isNullOrEmpty(fullName)) {
                sql += " and fullname like '%" + fullName + "%'";
                // sql += " and name like ?";
            }

           

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = ConnectionUtils.getConnection();
            stmt = conn.createStatement();
            // stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            // stmt.setInt(1, floorArea);
            // stmt.setString(2, "%" + name + "%");
            // rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                /*System.out.print("ID: " + rs.getInt("id") + " - type: " + rsmd.getColumnType(1));
                System.out.print(", Name: " + rs.getString("name") + " - type: " + rsmd.getColumnType(2));
                String address = rs.getString("street") + ", " + rs.getString("ward") + ", " + rs.getString("district");
                System.out.println(", Address: " + address);*/
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                // conn.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

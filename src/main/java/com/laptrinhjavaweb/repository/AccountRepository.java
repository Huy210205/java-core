package com.laptrinhjavaweb.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

public class AccountRepository{
    

    public static void main(String[] args) {
        // Input:
       
        String userName = null;
        
        ResultSet rs = null;
        Connection conn = null; 
        Statement stmt = null;
        try {
            String sql = "select * from account "+SystemConstant.ONE_EQUAL_ONE+"";
          
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql += " and username like '%" + userName + "%'";
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

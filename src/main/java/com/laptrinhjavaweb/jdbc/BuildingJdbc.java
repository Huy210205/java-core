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

public class BuildingJdbc {
   
    public static void main(String[] args) {
        // Input:
        Integer floorArea = 100;
        String name = "1";
        String street = null;
        String ward = null;
        String district = null;
        

        Connection conn = null; 
        Statement stmt = null;
        ResultSet rs = null;

        try {
            StringBuilder sql = new StringBuilder ("select * from building "+SystemConstant.ONE_EQUAL_ONE+"");
            if (floorArea != null) {
                sql.append(  " and floorarea = " + floorArea + "");
                // sql += " and floorarea = ?";
            }

            if (!StringUtils.isNullOrEmpty(name)) {
            	sql.append( " and name like '%" + name + "%'");
                // sql += " and name like ?";
            }

            if (!StringUtils.isNullOrEmpty(ward)) {
                sql.append (" and ward like '%" + ward + "%'");
            }

            if (!StringUtils.isNullOrEmpty(street)) {
            	sql.append (" and street like '%" + street + "%'");
            }

            if (!StringUtils.isNullOrEmpty(district)) {
            	sql.append(" and district like '%" + district + "%'");
            }

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = ConnectionUtils.getConnection();
            stmt = conn.createStatement();
            // stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql.toString());
            // stmt.setInt(1, floorArea);
            // stmt.setString(2, "%" + name + "%");
            // rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id") + " - type: " + rsmd.getColumnType(1));
                System.out.print(", Name: " + rs.getString("name") + " - type: " + rsmd.getColumnType(2));
                String address = rs.getString("street") + ", " + rs.getString("ward") + ", " + rs.getString("district");
                System.out.println(", Address: " + address);
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

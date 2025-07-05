package com.data.business.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/qldt";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection openConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            return conn;
        }
        catch (Exception e) {
            System.out.println("Kết nối db lỗi!");
            e.printStackTrace();
        }

        return null;
    }
}

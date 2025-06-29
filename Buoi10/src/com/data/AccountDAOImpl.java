package com.data;

import com.data.connection.ConnectionDB;
import com.data.model.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl {
    public boolean getAccount(String userName, String pass) {
        Connection conn = null;

        try {
            conn = ConnectionDB.openConn();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM account WHERE username = '" + userName + "' AND password = '" + pass + "'");
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return false;
    }
}

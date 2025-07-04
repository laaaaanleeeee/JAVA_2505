package com.data;

import com.data.connection.ConnectionDB;
import com.data.model.Account;

import java.sql.CallableStatement;
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

            CallableStatement callSt = conn.prepareCall("CALL checkAccount(?,?)");
            callSt.setString(1, userName);
            callSt.setString(2, pass);

            ResultSet rs = callSt.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return false;
    }
}

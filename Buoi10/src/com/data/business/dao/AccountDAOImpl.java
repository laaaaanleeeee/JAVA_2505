package com.data.business.dao;

import com.data.business.config.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class AccountDAOImpl implements AccountDAO{
    public boolean getAccount(String userName, String pass) {
        Connection conn = null;

        try {
            conn = ConnectionDB.openConn();

            CallableStatement callSt = conn.prepareCall("CALL checkAccount(?,?)");
            callSt.setString(1, userName);
            callSt.setString(2, pass);

            ResultSet rs = callSt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
            return false;
        }
    }
}

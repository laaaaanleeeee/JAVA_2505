package com.data.business.dao;

import com.data.business.config.ConnectionDB;
import com.data.business.model.Customer;
import com.data.business.model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
    public List<Customer> getListCustomer() {
        Connection conn = null;
        List<Customer> customers = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                int cusId = rs.getInt("customer_id");
                String cusName = rs.getString("name");
                String cusPhone = rs.getString("phone");
                String cusEmail = rs.getString("email");
                String cusAddress = rs.getString("address");

                Customer customer = new Customer(cusId, cusName, cusPhone, cusEmail, cusAddress);
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
        return customers;
    }

    public int deleteCus(int id) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("{CALL delete_cus_by_id(?)}");
            callSt.setInt(1, id);

            countAffect = callSt.executeUpdate();
            System.out.println("Xóa khách hàng có id là " + id + " thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return countAffect;
    }

    public int updateCus(Customer customer) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL update_cus(?,?,?,?,?)");
            callSt.setInt(1, customer.getCusId());
            callSt.setString(2, customer.getCusName());
            callSt.setString(3, customer.getCusPhone());
            callSt.setString(4, customer.getCusEmail());
            callSt.setString(5, customer.getCusAddress());
            countAffect = callSt.executeUpdate();

            System.out.println("Cập nhật thông tin khách hàng thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
        return countAffect;
    }

    public int saveNewCus(Customer customer) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("{CALL add_cus(?,?,?,?)}");
            callSt.setString(1, customer.getCusName());
            callSt.setString(2, customer.getCusPhone());
            callSt.setString(3, customer.getCusEmail());
            callSt.setString(4, customer.getCusAddress());
            countAffect = callSt.executeUpdate();

            System.out.println("Thêm khách hàng mới thành công, tên khách hàng: " + customer.getCusName());
        }
        catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
        return countAffect;
    }
}

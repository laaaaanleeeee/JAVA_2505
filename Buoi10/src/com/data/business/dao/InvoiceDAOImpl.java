package com.data.business.dao;

import com.data.business.config.ConnectionDB;
import com.data.business.model.Invoice;
import com.data.business.model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDAOImpl implements InvoiceDAO {
    public List<Invoice> getListInvoice() {
        Connection conn = null;
        List<Invoice> invoices = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("select * from invoices");
            while (rs.next()) {
                int invoiceId = rs.getInt("invoice_id");
                int cusId = rs.getInt("customer_id");
                Date invoiceDate = rs.getDate("invoice_date");
                double totalAmount = rs.getDouble("total_amount");

                Invoice invoice = new Invoice(invoiceId, cusId, invoiceDate, totalAmount);
                invoices.add(invoice);
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
        return invoices;
    }


    public int saveNewInvoice(Invoice invoice) {
        Connection conn = null;
        int countAffect = 0;
        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("{CALL add_order(?,?,?)}");

            java.sql.Date sqlDate = new java.sql.Date(invoice.getInvoiceDate().getTime());

            callSt.setInt(1, invoice.getCusId());
            callSt.setDate(2, sqlDate);
            callSt.setDouble(3, invoice.getTotalAmount());
            countAffect = callSt.executeUpdate();

            System.out.println("Thêm hoá đơn mới thành công");
        }
        catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }
        return countAffect;
    }


    public List<Invoice> searchListInvoiceByCusName(String cusName_in) {
        Connection conn = null;
        List<Invoice> invoices = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL searchOrderByCusName(?)");
            callSt.setString(1, cusName_in);

            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                int invoiceId = rs.getInt("invoice_id");
                int cusId = rs.getInt("customer_id");
                Date invoiceDate = rs.getDate("invoice_date");
                double totalAmount = rs.getDouble("total_amount");

                Invoice invoice = new Invoice(invoiceId, cusId, invoiceDate, totalAmount);
                invoices.add(invoice);
            }
            else {
                System.out.println("Không có hoá đơn phù hợp với tên khách hàng");
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return invoices;
    }


    public List<Invoice> searchOrderByDate(String dateIn) {
        Connection conn = null;
        List<Invoice> invoices = new ArrayList<>();

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL searchOrderByDate(?)");
            callSt.setString(1, dateIn);

            ResultSet rs = callSt.executeQuery();
            boolean findedInvoice = false;
            while (rs.next()) {
                findedInvoice = true;
                int invoiceId = rs.getInt("invoice_id");
                int cusId = rs.getInt("customer_id");
                Date invoiceDate = rs.getDate("invoice_date");
                double totalAmount = rs.getDouble("total_amount");

                Invoice invoice = new Invoice(invoiceId, cusId, invoiceDate, totalAmount);
                invoices.add(invoice);
            }
            if(!findedInvoice) {
                System.out.println("Không có hoá đơn phù hợp với ngày tạo");
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu!");
        }

        return invoices;
    }


    public void getStatisticsByDay(int year_in, int month_in) {
        Connection conn = null;

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL statisticsByDay(?,?)");
            callSt.setInt(1, year_in);
            callSt.setInt(2, month_in);

            ResultSet rs = callSt.executeQuery();

            boolean findedRs = false;
            while (rs.next()) {
                findedRs = true;
                Date date = rs.getDate("date");
                double total = rs.getDouble("total");

                System.out.println("Tổng doanh thu theo ngày " + date + " là: " + total);
            }
            if (!findedRs){
                System.out.println("Không có dữ liệu cho tháng " + month_in + ", năm " + year_in);
            }
        }
        catch (Exception e ) {
            System.out.println("Lỗi lấy dữ liệu!");
            e.printStackTrace();
        }
    }

    public void statisticsByMonth(int year_in) {
        Connection conn = null;

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL statisticsByMonth(?)");
            callSt.setInt(1, year_in);


            ResultSet rs = callSt.executeQuery();
            boolean findedRs = false;

            while (rs.next()) {
                findedRs = true;
                int month = rs.getInt("month");
                double total = rs.getDouble("total");

                System.out.println("Thống kê doanh thu theo tháng " + month + " là: " + total);
            }
            if(!findedRs) {
                System.out.println("Không có dữ liệu cho năm " + year_in);
            }

        }
        catch (Exception e ) {
            System.out.println("Lỗi lấy dữ liệu!");
            e.printStackTrace();
        }
    }


    public void statisticsByYear() {
        Connection conn = null;

        try {
            conn = ConnectionDB.openConn();
            CallableStatement callSt = conn.prepareCall("CALL statisticsByYear()");

            ResultSet rs = callSt.executeQuery();
            boolean findedRs = false;

            while (rs.next()) {
                findedRs = true;
                int year = rs.getInt("year");
                double total = rs.getDouble("total");

                System.out.println("Thống kê doanh thu theo năm " + year + " là: " + total);
            }
            if(!findedRs) {
                System.out.println("Không có dữ liệu");
            }

        }
        catch (Exception e ) {
            System.out.println("Lỗi lấy dữ liệu!");
            e.printStackTrace();
        }
    }
}

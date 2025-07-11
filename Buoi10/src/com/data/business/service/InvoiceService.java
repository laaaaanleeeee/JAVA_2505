package com.data.business.service;

import com.data.business.dao.InvoiceDAO;
import com.data.business.dao.InvoiceDAOImpl;
import com.data.business.model.Invoice;

import java.util.List;

public class InvoiceService {
    private InvoiceDAO invoiceDAO = new InvoiceDAOImpl();

    public List<Invoice> getListInvoice() {
        return invoiceDAO.getListInvoice();
    }

    public void saveNewInvoice(Invoice invoice) {
        invoiceDAO.saveNewInvoice(invoice);
    }

    public List<Invoice> searchListInvoiceByCusName(String cusName_in) {
        return invoiceDAO.searchListInvoiceByCusName(cusName_in);
    }

    public List<Invoice> searchOrderByDate(String dateIn) {
        return invoiceDAO.searchOrderByDate(dateIn);
    }


    public void getStatisticsByDay(int year_in, int month_in) {
        invoiceDAO.getStatisticsByDay(year_in, month_in);
    }

    public void getStatisticsByMonth(int year_in) {
        invoiceDAO.statisticsByMonth(year_in);
    }

    public void statisticsByYear() {
        invoiceDAO.statisticsByYear();
    }

    public void show(List<Invoice> invoices) {
        System.out.println("==== Danh sách khách hàng ====");

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|  Invoice Id  |   Customer Id  |   Invoice Date  |   Total Amount  |");
        invoices.forEach(invoice -> {
            StringBuilder row = new StringBuilder();
            row.append("|  " + invoice.getInvoiceId());
            row.append("|  " + invoice.getCusId());
            row.append("|  " + invoice.getInvoiceDate());
            row.append("|  " + invoice.getTotalAmount() + "   |");

            System.out.println(row);
        });
        System.out.println("--------------------------------------------------------------------------------------");

    }
}

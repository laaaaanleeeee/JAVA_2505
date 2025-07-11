package com.data.business.dao;

import com.data.business.model.Invoice;

import java.util.List;

public interface InvoiceDAO {
    List<Invoice> getListInvoice();
    int saveNewInvoice(Invoice invoice);
    List<Invoice> searchListInvoiceByCusName(String cusName_in);
    List<Invoice> searchOrderByDate(String dateIn);
    void getStatisticsByDay(int year_in, int month_in);
    void statisticsByMonth(int year_in);
    void statisticsByYear();
}

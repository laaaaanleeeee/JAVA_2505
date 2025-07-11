package com.data.business.model;

import java.util.Date;

public class Invoice {
    private int invoiceId;
    private int cusId;
    private Date invoiceDate;
    private double totalAmount;


    public Invoice () {

    }

    public Invoice(int invoiceId, int cusId, Date invoiceDate, double totalAmount) {
        this.invoiceId = invoiceId;
        this.cusId = cusId;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

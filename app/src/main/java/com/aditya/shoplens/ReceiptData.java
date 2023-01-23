package com.aditya.shoplens;

public class ReceiptData {

    String receiptID, receiptDate, receiptAmount;

    public  ReceiptData(){}

    public ReceiptData(String receiptID, String receiptDate, String receiptAmount) {
        this.receiptID = receiptID;
        this.receiptDate = receiptDate;
        this.receiptAmount = receiptAmount;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }
}

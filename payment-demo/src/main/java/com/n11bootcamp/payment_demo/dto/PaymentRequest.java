package com.n11bootcamp.payment_demo.dto;

public class PaymentRequest {
    private String method;
    private double amount;
    private String customerName;

    public PaymentRequest() {
    }

    public PaymentRequest(String method, double amount, String customerName) {
        this.method = method;
        this.amount = amount;
        this.customerName = customerName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
package com.n11bootcamp.payment_demo.dto;

public class PaymentResponse {
    private boolean success;
    private String message;
    private double amount;
    private String method;

    public PaymentResponse() {
    }

    public PaymentResponse(boolean success, String message, double amount, String method) {
        this.success = success;
        this.message = message;
        this.amount = amount;
        this.method = method;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
package com.n11bootcamp.payment_demo.payment;

import com.n11bootcamp.payment_demo.dto.PaymentRequest;
import com.n11bootcamp.payment_demo.dto.PaymentResponse;

public interface PaymentMethod {
    String getMethodName();

    PaymentResponse pay(PaymentRequest request);
}

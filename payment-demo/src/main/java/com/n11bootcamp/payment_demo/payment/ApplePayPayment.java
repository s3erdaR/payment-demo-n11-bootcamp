package com.n11bootcamp.payment_demo.payment;

import com.n11bootcamp.payment_demo.dto.PaymentRequest;
import com.n11bootcamp.payment_demo.dto.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class ApplePayPayment implements PaymentMethod {

    @Override
    public String getMethodName() {
        return "applePay";
    }

    @Override
    public PaymentResponse pay(PaymentRequest request) {
        return new PaymentResponse(true, "Apple Pay ile ödeme başarılı", request.getAmount(), getMethodName());
    }
}
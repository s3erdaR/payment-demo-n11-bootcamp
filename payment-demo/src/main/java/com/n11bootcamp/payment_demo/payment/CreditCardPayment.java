package com.n11bootcamp.payment_demo.payment;

import com.n11bootcamp.payment_demo.dto.PaymentRequest;
import com.n11bootcamp.payment_demo.dto.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentMethod {

    @Override
    public String getMethodName() {
        return "creditCard";
    }

    @Override
    public PaymentResponse pay(PaymentRequest request) {
        return new PaymentResponse(
                true,
                "Kredi Kartı ile ödeme başarılı",
                request.getAmount(),
                getMethodName()
        );
    }
}

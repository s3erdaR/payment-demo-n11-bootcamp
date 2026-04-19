package com.n11bootcamp.payment_demo.service;

import com.n11bootcamp.payment_demo.dto.PaymentRequest;
import com.n11bootcamp.payment_demo.dto.PaymentResponse;
import com.n11bootcamp.payment_demo.payment.PaymentMethod;
import com.n11bootcamp.payment_demo.payment.PaymentMethodFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentMethodFactory paymentMethodFactory;

    public PaymentService(PaymentMethodFactory paymentMethodFactory) {
        this.paymentMethodFactory = paymentMethodFactory;
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        return (PaymentResponse) paymentMethodFactory.invokePayWithReflection(
                request.getMethod(),
                request
        );
    }

    public List<String> getSupportedMethods() {
        return paymentMethodFactory.getSupportedMethods();
    }
}

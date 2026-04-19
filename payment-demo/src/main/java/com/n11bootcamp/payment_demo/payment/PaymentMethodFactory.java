package com.n11bootcamp.payment_demo.payment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PaymentMethodFactory {

    private final Map<String, PaymentMethod> paymentMethodMap;

    public PaymentMethodFactory(List<PaymentMethod> paymentMethods) {
        this.paymentMethodMap = paymentMethods.stream()
                .collect(Collectors.toMap(PaymentMethod::getMethodName, method -> method));
    }

    public PaymentMethod getPaymentMethod(String methodName) {
        PaymentMethod paymentMethod = paymentMethodMap.get(methodName);
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Desteklenmeyen ödeme yöntemi: " + methodName);
        }
        return paymentMethod;
    }

    public List<String> getSupportedMethods() {
        return paymentMethodMap.keySet().stream().toList();
    }
}
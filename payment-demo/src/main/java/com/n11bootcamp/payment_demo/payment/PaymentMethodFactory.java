package com.n11bootcamp.payment_demo.payment;

import com.n11bootcamp.payment_demo.dto.PaymentRequest;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
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

    public Object invokePayWithReflection(String methodName, PaymentRequest request) {
        try {
            PaymentMethod paymentMethod = getPaymentMethod(methodName);

            Class<?> cls = paymentMethod.getClass();

            Method payMethod = cls.getMethod("pay", PaymentRequest.class);

            return payMethod.invoke(paymentMethod, request);

        } catch (Exception e) {
            throw new RuntimeException("Reflection ile ödeme çağrısı başarısız", e);
        }
    }

    public List<String> getSupportedMethods() {
        return paymentMethodMap.keySet().stream().toList();
    }
}
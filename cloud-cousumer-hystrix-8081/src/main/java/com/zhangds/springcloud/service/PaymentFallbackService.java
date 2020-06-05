package com.zhangds.springcloud.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentOK(Integer id) {
        return "fallback paymentOK";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "fallback paymentTimeout";
    }
}

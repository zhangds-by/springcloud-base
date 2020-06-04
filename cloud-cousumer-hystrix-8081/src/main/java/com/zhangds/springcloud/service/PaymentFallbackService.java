package com.zhangds.springcloud.service;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
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

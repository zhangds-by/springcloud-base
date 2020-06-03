package com.zhangds.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentOK(Integer id){
        return Thread.currentThread().getName() + "payment_OK" + id;
    }

    public String paymentTimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "payment_timeout" + id;
    }
}

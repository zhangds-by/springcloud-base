package com.zhangds.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {


    public String paymentOK(Integer id){
        return Thread.currentThread().getName() + "payment_OK" + id;
    }

//    @HystrixCommand
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    }) //降级时间为5s，当响应时间大于5s就会出现服务降级
    public String paymentTimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "payment_timeout" + id;
    }

    public String paymentTimeOutHandler(Integer id){
        return Thread.currentThread().getName() + "系统繁忙或报错，稍后再试";
    }
}

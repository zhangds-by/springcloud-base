package com.zhangds.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhangds.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("consumer")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOK(@PathVariable Integer id){
        return paymentService.paymentOK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    }) //ribbon默认响应时间为1s
    public String paymentTimeout(@PathVariable Integer id){
        return paymentService.paymentTimeout(id);
    }

    public String paymentTimeOutHandler(Integer id){
        return "消费端请求，提供端繁忙或消费端出错";
    }
}

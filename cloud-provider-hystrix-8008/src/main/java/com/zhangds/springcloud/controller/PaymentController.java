package com.zhangds.springcloud.controller;

import com.zhangds.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOK(@PathVariable Integer id){
        return paymentService.paymentOK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeOut(@PathVariable Integer id){
        return paymentService.paymentTimeOut(id);
    }
}

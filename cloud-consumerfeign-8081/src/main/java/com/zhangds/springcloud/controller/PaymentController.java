package com.zhangds.springcloud.controller;

import com.zhangds.springcloud.entities.CommonResult;
import com.zhangds.springcloud.entities.Payment;
import com.zhangds.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhangds
 * 2020-05-28 20:09
 **/
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }
}

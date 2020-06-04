package com.zhangds.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-provider-hystrix", fallback = PaymentFallbackService.class)
@RequestMapping("provider")
public interface PaymentService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentOK(@PathVariable(value = "id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTimeout(@PathVariable(value = "id") Integer id);
}

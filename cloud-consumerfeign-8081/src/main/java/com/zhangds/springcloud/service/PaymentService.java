package com.zhangds.springcloud.service;

import com.zhangds.springcloud.entities.CommonResult;
import com.zhangds.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * openFeign = feign + springMVC注解
 * 映射路径配置的是 服务提供者服务Controller的路径
 * Create by zhangds
 * 2020-05-28 20:05
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
@RequestMapping("provider")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}

package com.zhangds.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author zhangds
 * @date 2020/6/5 9:50
 */
@Component
@FeignClient(value = "cloud-provider-hystrix", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/provider/payment/hystrix/ok/{id}")
    String paymentOK(@PathVariable(value = "id") Integer id);

    @GetMapping("/provider/payment/hystrix/timeout/{id}")
    String paymentTimeout(@PathVariable(value = "id") Integer id);
}

package com.zhangds.springcloud.controller;

import com.zhangds.springcloud.entities.CommonResult;
import com.zhangds.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 服务调用
 *      ribbon + restTemplate 编程式
 *      Feign接口注解
 * Create by zhangds
 * 2020-05-20 10:17
 **/
@RestController
@RequestMapping("consumer")
public class PaymentController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    //使用服务名调用需要添加负载均衡@LoadBalanced注解
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/getForObject/{id}")
    public CommonResult<Payment> getPaymentForObject(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(503, "操作失败");
        }
    }

}

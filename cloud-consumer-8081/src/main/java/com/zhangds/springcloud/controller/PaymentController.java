package com.zhangds.springcloud.controller;

import com.zhangds.springcloud.entities.CommonResult;
import com.zhangds.springcloud.entities.Payment;
import com.zhangds.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
    public static final String PAYMENT_URL = "http://cloud-provider-service";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancer loadBalancer;

    //getForObject方法为响应体中数据转化成的对象，基本上可以理解为Json。
    @GetMapping("/payment/getForObject/{id}")
    public CommonResult<Payment> getPaymentForObject(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/provider/payment/get/"+id, CommonResult.class);
    }

    //getForEntity方法返回对象为ResponseEntity对象，包含响应中一些重要的信息，比如响应头、响应状态码、响应体等
    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/provider/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(503, "操作失败");
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.getServiceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/provider/payment/lb", String.class);

    }

}

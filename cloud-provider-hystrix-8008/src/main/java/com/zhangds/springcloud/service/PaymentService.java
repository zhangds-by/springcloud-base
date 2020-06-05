package com.zhangds.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    /**
     * 服务熔断
     * @author zhangds
     * @date 2020/6/5 9:59
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数！");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "  调用成功  流水号：" + serialNumber;
    }

    /**
     * 服务熔断最终解决方案
     * @author zhangds
     * @date 2020/6/5 10:07
     */
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "系统异常, id 不能为负数" + id;
    }
}

package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //启动降级服务
public class CloudProviderHystrix8008App {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrix8008App.class, args);
    }
}

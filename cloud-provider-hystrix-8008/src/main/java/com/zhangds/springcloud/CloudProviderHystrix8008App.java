package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProviderHystrix8008App {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrix8008App.class, args);
    }
}

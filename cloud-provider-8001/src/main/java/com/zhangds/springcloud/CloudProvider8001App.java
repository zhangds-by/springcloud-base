package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Create by zhangds
 * 2020-05-19 18:12
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudProvider8001App {
    public static void main(String[] args) {
        SpringApplication.run(CloudProvider8001App.class);
    }
}

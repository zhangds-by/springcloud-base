package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create by zhangds
 * 2020-05-19 18:12
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProvider8004App {
    public static void main(String[] args) {
        SpringApplication.run(CloudProvider8004App.class, args);
    }
}

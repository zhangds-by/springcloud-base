package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create by zhangds
 * 2020-05-25 18:08
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderConsul8006App {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderConsul8006App.class, args);
    }
}

package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Create by zhangds
 * 2020-05-20 09:29
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-SERVICE")
public class CloudConsumer8081App {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumer8081App.class, args);
    }

}

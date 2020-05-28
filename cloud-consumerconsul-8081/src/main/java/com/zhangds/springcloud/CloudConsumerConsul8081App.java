package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Create by zhangds
 * 2020-05-25 19:36
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerConsul8081App {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerConsul8081App.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

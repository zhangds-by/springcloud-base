package com.zhangds.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Create by zhangds
 * 2020-05-28 19:28
 **/
@EnableFeignClients
@SpringBootApplication
public class CloudConsumerFeign8081App {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeign8081App.class, args);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

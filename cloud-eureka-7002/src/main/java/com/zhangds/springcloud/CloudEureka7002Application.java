package com.zhangds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Create by zhangds
 * 2020-05-20 09:54
 **/
@SpringBootApplication
@EnableEurekaServer
public class CloudEureka7002Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudEureka7002Application.class);
    }
}

package com.zhangds.springcloud;

import com.zhangds.springcloud.rule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Create by zhangds
 * 2020-05-20 09:29
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-provider-service", configuration = MyRuleConfig.class)
public class CloudConsumer8081App {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumer8081App.class, args);
    }


    @Bean
//    @LoadBalanced  // 使用系统的复杂均衡时 需要加上 java.net.UnknownHostException: cloud-provider-service
    public RestTemplate getTestTemplate() {
        return new RestTemplate();
    }

    //使用自定义负载均衡时，不需要加上注解
    //java.lang.IllegalStateException: No instances available for 192.168.25.1
}

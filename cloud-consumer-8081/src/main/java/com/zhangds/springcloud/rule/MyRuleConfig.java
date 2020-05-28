package com.zhangds.springcloud.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * config的类名也会被注册为Bean，不能和方法名称相同
 * Create by zhangds
 * 2020-05-27 18:04
 **/
@Configuration
public class MyRuleConfig {

    @Bean
    public IRule myRule(){
        return new RandomRule(); //指定负载均衡算法为随机
    }
}

package com.zhangds.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create by zhangds
 * 2020-05-25 19:39
 **/
@RestController
@Slf4j
@RequestMapping("consumer")
public class ConsulConsumerController {
    public static final String INVOKE_URL = "http://consul-provider-server";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String getConsulInfo(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}

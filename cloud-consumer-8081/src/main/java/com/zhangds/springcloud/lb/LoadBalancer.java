package com.zhangds.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Create by zhangds
 * 2020-05-28 09:53
 **/
public interface LoadBalancer {
    ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}

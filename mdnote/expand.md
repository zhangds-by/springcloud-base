Hystrix压力测试

    在多线程组的情况下，ok和timeout接口都会出现等待超时报错 Read timed out 
    
    使用 @HystrixCommand 注解, 使用默认的提示信息
        timeout接口 出现异常或超时时，paymentTimeout short-circuited and fallback failed
        ok接口 可以正常访问
        
    服务降级的理解就是访问异常或超时的服务不会影响其他访问，服务返回提示信息
    
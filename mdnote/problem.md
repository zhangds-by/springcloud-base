eureka

    1、消费端通过提供端注册的名称调用服务
    java.net.UnknownHostException: CLOUD-PROVIDER-SERVICE
    
    restTemplate只是类似于httpclient的一种发送rest风格的请求，
    只有@loadBalance注解修饰的restTemplate才能实现服务名的调用，设置负载均衡之后才能在多个服务提供者调用服务
    
    
consul
    
    注册列表中，critical报错
    加上 spring.cloud.consul.discovery.heartbeat.enabled=true 配置
    
服务调用ribbon + 远程调用RestTemplate

    远程调用路径错误 ：
        org.springframework.web.client.HttpClientErrorException$NotFound: 404

Feign & openFeign

    feign.FeignException$NotFound: status 404 reading PaymentService#getPaymentById(Long)
    feignClient接口配置的是 服务提供者的路径
    
    PathVariable annotation was empty on param 0
    Feign远程服务需要显式指定参数名称 : @PathVariable(value = "id") Integer id
    
Hystrix 

    com.zhangds.springcloud.service.PaymentService#paymentOK(Integer)
    to {GET /provider/payment/hystrix/ok/{id}}: There is already 'paymentFallbackService' bean method
    com.zhangds.springcloud.service.PaymentFallbackService#paymentOK(Integer) mapped
    
    PaymentService接口uri路径配置错误，接口上不能配置映射路径
    
    Hystrix DashBoard 监控一直loading
    
        执行 http://localhost:8008/hystrix.stream ping的请求数据为null
        需要先发送一次请求
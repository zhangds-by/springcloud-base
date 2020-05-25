eureka

    1、消费端通过提供端注册的名称调用服务
    java.net.UnknownHostException: CLOUD-PROVIDER-SERVICE
    
    restTemplate只是类似于httpclient的一种发送rest风格的请求，
    只有@loadBalance注解修饰的restTemplate才能实现服务名的调用，设置负载均衡之后才能在多个服务提供者调用服务
    
    

    
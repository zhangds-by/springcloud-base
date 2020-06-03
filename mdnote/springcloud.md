Cloud命名规则

版本对应 https://start.spring.io/actuator/info

tools
    
    <!-- RunDashboard -->
    <component name="RunDashboard">
        <option name="configurationTypes">
          <set>
            <option value="SpringBootApplicationConfigurationType" />
          </set>
        </option>
    </component>
    
    <!-- 热部署 父模块 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <fork>true</fork>
                    <addResources>true</addResources>
                </configuration>
            </plugin>
        </plugins>
    </build>
    
    <!-- 热部署 子模块 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

springcloud架构

	服务注册中心
		Eureka：向EurekaServer注册服务并可从EurekaServer获取需要调用的服务地址信息；
                需要向外提供服务的应用，需要使用EurekaClient来向Server注册服务。
            1. 搭建服务注册中心 cloud-eureka-7001 + @EnableEurekaServer
            2. 注册服务提供者 @EnableDiscoveryClient + @EnableEurekaClient
            3. 服务发现和消费 @LoadBalanced + RestTemplate + @EnableEurekaClient
		    4. 自我保护：网络不通，存在网络分区故障发生（延时、卡顿、拥挤）不会立即删除服务
		Zookeeper
		Consul
		Nacos 推荐
		
	负载均衡和服务调用
		Ribbon：负责进行客户端负载均衡的组件；一般与RestTemplate结合
		    用于服务调用者向被调用者进行服务调用，并且如果服务者有多个节点时，会进行客户端的负载均衡处理
		    
		    RestTemplate：getForObject方法为响应体中数据转化成的对象，基本上可以理解为Json。
                         getForEntity方法返回对象为ResponseEntity对象，包含响应中一些重要的信息，比如响应头、响应状态码、响应体等。
		       
            Ribbon 负载算法 IRule 
		LoadBalancer
		
	服务调用
		Feign
		OpenFeign
		    监控级别
                NONE：默认的，不显示任何日志。
                BASIC：仅记录请求方法、URL、响应状态码以及执行时间。
                HEADERS：除了BASIC中定义的信息之外，还有请求和响应头的信息。
                FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
	服务降级
		Hystrix
		resilience4j 国外使用多
		alibaba Sentinel 国内使用多
	服务网关
		Zuul
		Zuul2
		gateway
	服务配置
		Config
		Nacos
		apollo
	服务主线
		Bus
		Nacos
		
学习网站
    
    springcloud中文文档：https://www.bookstack.cn/read/spring-cloud-docs/docs-project-SpringCloudSleuth.md
    springcloud官方文档：https://cloud.spring.io/spring-cloud-static/Hoxton.SR1/reference/htmlsingle/
    springboot官方文档：https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/
    

    
    
    
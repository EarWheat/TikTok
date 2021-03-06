
@[TOC](目录)

# 一、盘古简介

​      盘古是一款涵盖**业务常用功能**（诸如Http、MQ、Redis、Kafka等）的SDK。是本人在学习的时候，总结积累的。通过pom包的形式可以引入项目，可以有效的避免重复在轮子的工作。
# 二、使用盘古

 1. 下载pangu包

```powershell
git clone git@github.com:EarWheat/Pangu.git
```

 2. 安装pom包到本地maven仓库

```powershell
# 进入Pangu所在根目录执行mvn命令，需提前安装maven
mvn clean 
mvn install
```

 3. 引入POM包

```
<dependency>
	<groupId>com.pangu</groupId>
	<artifactId>pangu</artifactId>
	<version>1.0.0-RELEASE</version>
</dependency>
```
 2. 在启动类上或者xml配置中配置扫描自动装载pangu中的内容为Bean

```java
@SpringBootApplication
@ComponentScan(value = "com.pangu")
@ComponentScan(value = "com.education")
public class ConfuciusApplication {
	public static void main(String[] args) {
	    SpringApplication.run(ConfuciusApplication.class, args);
	}
}
```
# 三、盘古功能介绍
## 3.1 MQ使用

 1. 添加Kafka相关配置
 2. 实现MqMessageListener接口。
 3. 添加@MqMessageListenerConfig注解。
 4. 注册为Bean
```powershell
kafka.servers=127.0.0.1:9092
kafka.auto-commit=true
kafka.auto-commit-interval=1000
kafka.session-time-out=30000
kafka.auto-offset-reset=earliest
```
```java
@MqMessageListenerConfig(topic = "confucius", consumerGroup = "confucius_consumer")
@Component
public class ConfuciusConsumer implements MqMessageListener {
    @Override
    public RestResult exec(ConsumerRecord<String, String> record) {
        System.out.println("do something service" + record.toString());
        return RestResult.successResult();
    }
}
```
底层实现为Kafka，可在exec中实现自己的消费逻辑，消费的记录为Kafka的ConsumerRecord类。


## 3.2 Redis封装

 1. 添加redis相关配置
 2. 直接使用RedisUtil类

```powershell
# redis
spring.redis.host=127.0.0.1
spring.redis.port=6379
spring.redis.password=
spring.redis.database=0
spring.redis.jedis.pool.max-active=50
spring.redis.jedis.pool.max-wait=3000
spring.redis.jedis.pool.max-idle=20
spring.redis.jedis.pool.min-idle=2
spring.redis.timeout=5000
```
```java
    @RequestMapping("/redisInfo")
    public RestResult getRedisInfo(){
        RedisUtil.set("name","Confucius");
        String hello = "Hello!".concat(RedisUtil.get("name"));
        return RestResult.successResult(hello);
    }
```
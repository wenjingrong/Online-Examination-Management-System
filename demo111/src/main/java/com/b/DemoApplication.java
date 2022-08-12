package com.b;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//组合注解，开启自动配置，扫描当前入口类所在包及子包的注解
@MapperScan("com.b.dao")//扫描mapper指定dao接口所在的包
//入口类
public class DemoApplication {
    public static void main(String[] args) {
        //启动springboot应用，项目部署到web容器中
        //参数1：传入入口类的类对象，2：main函数的参数
        SpringApplication.run(DemoApplication.class, args);
    }
}

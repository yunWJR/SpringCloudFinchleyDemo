package com.yun.yscd.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // Ek 服务发现

public class YunServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(YunServiceUserApplication.class, args);
    }
}

package com.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author LiYabin
 */
@SpringBootApplication
@RestController
@EnableCaching
@MapperScan(basePackages = "com.pay.database.mybatis.mapper")
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class,args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "欢迎来spring boot2.0项目开发!";
    }
}

package com.leyou.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yd
 * @version 1.0
 * @date 2020/2/21 17:43
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class leyouSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(leyouSearchApplication.class, args);
    }
}

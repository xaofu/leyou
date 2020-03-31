package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.activation.MailcapCommandMap;

@SpringBootApplication
@EnableEurekaServer
public class leyouRegisterApplicatiom {
    public static void main(String[] args) {
        SpringApplication.run(leyouRegisterApplicatiom.class,args);
    }
}

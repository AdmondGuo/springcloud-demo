package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class MemberImportApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(MemberImportApplication.class, args);
    }
    @Bean
    @LoadBalanced        // 开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}




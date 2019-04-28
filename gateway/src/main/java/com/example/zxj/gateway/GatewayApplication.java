package com.example.zxj.gateway;

import com.example.zxj.gateway.filter.UriKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    @Bean
    public UriKeyResolver uriKeyResolver(){
        return new UriKeyResolver();
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}


package com.example.zxj.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

import java.util.ArrayList;

@SpringBootApplication
// client add the dependency of spring-cloud-starter-zipkin
// and  SpringBootApplication could autoconfigure and register to the zipkinserver
@EnableZipkinServer
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

}

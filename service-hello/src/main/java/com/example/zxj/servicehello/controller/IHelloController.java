package com.example.zxj.servicehello.controller;

import com.example.zxj.servicehello.api.Hello;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//可在接口中直接定义映射路径，编写实现类即可，暴露的接口可被注册中心自动发现
@RestController
public class IHelloController implements Hello {

    @Override
    public String hello(HttpServletRequest request) {
        return "hello:"+request.getLocalPort();
    }
}

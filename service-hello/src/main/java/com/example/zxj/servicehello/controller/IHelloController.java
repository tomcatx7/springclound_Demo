package com.example.zxj.servicehello.controller;

import com.example.zxj.servicehello.api.Hello;
import com.example.zxj.servicehello.entity.User;
import com.example.zxj.servicehello.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//可在接口中直接定义映射路径，编写实现类即可，暴露的接口可被注册中心自动发现
@RestController
public class IHelloController implements Hello {
    @Autowired
    UserMapper userMapper;

    @Override
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        return "hello:"+request.getLocalPort()+userMapper.selectList(null);
    }
}

package com.example.zxj.servicehello.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

public interface Hello {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(HttpServletRequest request);
}

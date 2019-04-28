package com.example.zxj.feignclient.controller;

import com.example.zxj.feignclient.controller.feign.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class FeignController {

    @Autowired
    Hello hello;

    @RequestMapping(value = "test/hello",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return hello.myHello();
    }

    @RequestMapping(value = "test/info",method = RequestMethod.GET)
    @ResponseBody
    public String info(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        String header = null;
        StringBuffer sb = new StringBuffer();
        sb.append("headers:{\n");
        while ((header = headerNames.nextElement()) != null){
            sb.append(header+":"+request.getHeader(header)+",\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

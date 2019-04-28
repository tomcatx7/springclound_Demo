package com.example.zxj.feignclient.controller.feign;

import com.example.zxj.feignclient.controller.hystrix.HelloServiceFailureHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//根据feignclient根据对应服务注册的 spirng.application.name 取查找相应的服务
//且springboot自动注入容器
//feign是集成了Ribbon实现了负载均衡
//feign内部集成了熔断器fallback为发生异常时的回调方法实现的类，与借口方法一一对应
@FeignClient(value = "hello-service",fallback = HelloServiceFailureHandler.class)
public interface Hello {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String myHello();
}

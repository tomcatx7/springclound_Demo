package com.example.zxj.feignclient.controller.hystrix;

import com.example.zxj.feignclient.controller.feign.Hello;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFailureHandler implements Hello {
    @Override
    public String myHello() {
        return "调用hello（）异常";
    }
}

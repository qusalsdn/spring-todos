package com.qusalsdn.springboot.springtodos.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody // 메시지가 리턴한 것을 그대로 브라우저에 리턴하는 역할을 한다.
    public String sayHello() {
        return "Hello! What are you learning today?";
    }
}

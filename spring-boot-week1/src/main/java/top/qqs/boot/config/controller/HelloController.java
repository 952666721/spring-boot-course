package top.qqs.boot.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {

    @GetMapping("/strings")
    public List<String> strings() {
        return List.of("hello","world!");
    }

 @Value("${my.feature.helloSwitch}")
    private boolean isHelloEnabled;

    @Value("${my.feature.closeMsq}")
    private String closeMessage;

    @GetMapping("/hello")
    public String hello() {
        if (!isHelloEnabled) {
            return "接口开放中！欢迎访问我的第一个Spring Boot 项目~";
        }else {
            return closeMessage;
        }
    }
}

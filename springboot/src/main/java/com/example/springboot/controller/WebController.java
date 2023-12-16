package com.example.springboot.controller;


import com.example.springboot.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    /**
     * 默认请求接口
     */
    @GetMapping("/")
    public Result hello() {
        return Result.success();
    }

}

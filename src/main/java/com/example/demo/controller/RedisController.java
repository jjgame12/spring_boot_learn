package com.example.demo.controller;

import com.example.demo.enums.ResponseCode;
import com.example.demo.http.Response;
import com.example.demo.service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/get")
    public Response getByKey(@RequestParam String key) {
        String value = redisService.getStringByKey(key);
        return new Response<>(ResponseCode.SUCESS.getCode(), value);
    }
}

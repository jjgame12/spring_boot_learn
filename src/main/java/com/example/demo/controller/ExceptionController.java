package com.example.demo.controller;

import com.example.demo.exception.LocalException;
import com.example.demo.http.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试ExceptionHandler
 */
@RestController
@RequestMapping("/exception")
@Slf4j
public class ExceptionController {
    @GetMapping("/test")
    public Response<String> testException() throws LocalException {
        throw new LocalException("exception handler");
    }

    @GetMapping("/t1")
    public Response testOtherException() throws Exception {
        throw new Exception();
    }
}

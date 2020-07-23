package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class ResourceService {
    public String print() {
        String result = "resource";
        System.out.println(result);
        return result;
    }
}

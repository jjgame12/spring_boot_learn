package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalService {

    private static String name;

    @Value("${localData.name}")
    public void setName(String nm) {
        name = nm;
    }

    public static String getName() {
        return name;
    }
}

package com.example.demo.service;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class NoDefaultConstructorClass {
    private String string;

    public NoDefaultConstructorClass() {
        string = "default";
    }

    // 如果只写这个，不写上面的，那么是不能注入成功的，因为默认找不到str的
    public NoDefaultConstructorClass(String str) {
        string = str;
    }

}

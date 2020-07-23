package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class II {

    public static int i;

    @Value("${ii}")
    public void setI(int ii) {
        i = ii;
    }

    public int getI() {
        return i;
    }

    public II() {
        System.out.println("ii is " + i);
    }
}

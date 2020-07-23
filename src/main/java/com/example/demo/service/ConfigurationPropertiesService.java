package com.example.demo.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 不用setter可以注入配置的值吗
 */
@Component
@ConfigurationProperties(prefix = "properties")
public class ConfigurationPropertiesService {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

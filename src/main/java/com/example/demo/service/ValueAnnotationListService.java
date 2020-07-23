package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * yml以数组形式注入
 */
@Component
public class ValueAnnotationListService {
    @Value("#{'${list.addresses}'.split(',')}")
    private List<String> addresses;

    public List<String> getAddresses() {
        return addresses;
    }
}

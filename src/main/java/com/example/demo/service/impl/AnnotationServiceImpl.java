package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.AnnotationService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AnnotationServiceImpl implements AnnotationService {
    private int id;

    @Resource(name = "user")
    private User user;

    @Override
    public String getResource() {
        return "resource";
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getUserName() {
        log.info("come into func getUserName");
        return user.getUserName();
    }
}

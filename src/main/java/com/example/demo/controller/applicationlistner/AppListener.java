package com.example.demo.controller.applicationlistner;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;

/**
 * spring启动时调用
 * @author jj
 */
//@WebListener // 不能使用@WebListener，启动会有异常
@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("*********application begins to start******");
    }
}

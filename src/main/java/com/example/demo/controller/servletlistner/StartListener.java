package com.example.demo.controller.servletlistner;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 容器初始化时调用初始化
 * @author jj
 */
//@Component
@WebListener
public class StartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("******************start servlet context");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

package com.services;

import com.example.demo.DemoApplication;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class BeanTest {
    @Resource(name = "user")
    private User user;

    @Test
    public void testBean() {
        log.info("user name = {}", user.getUserName());
    }

}

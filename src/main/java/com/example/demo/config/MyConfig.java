package com.example.demo.config;

import com.example.demo.enums.UserSexEnum;
import com.example.demo.model.HigherUser;
import com.example.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Component;

/**
 * 使用@Configuration注解，higherUser()中的user和user()中的user是一个对象
 * 使用@Component注解，higherUser()中的user和user()中的user不是一个对象
 */
//@Component
@EnableRetry
@Configuration
public class MyConfig {
    @Bean
    public User user() {
        return new User("jj", "uuuuuu", UserSexEnum.MAN);
    }

    @Bean
    public HigherUser higherUser() {
        return new HigherUser(user());
    }
}

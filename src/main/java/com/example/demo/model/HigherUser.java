package com.example.demo.model;

/**
 * 测试@Configuration和@Component
 */
public class HigherUser {
    private User user;

    public HigherUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

package com.example.demo.mapper;

import com.example.demo.model.User;

import java.util.List;

public interface UserMapper {
    List<User> getAll();

    User getOne(Long id);

    User getSimpleOne(Long id);

    int insert(User user);

    void update(User user);

    void delete(Long id);
}

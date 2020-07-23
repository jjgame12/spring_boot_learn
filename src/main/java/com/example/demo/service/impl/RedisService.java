package com.example.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getStringByKey(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        log.info("[{}] : [{}]", key, value);
        return value;
    }
}

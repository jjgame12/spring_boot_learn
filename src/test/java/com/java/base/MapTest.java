package com.java.base;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    /**
     * key、value值可以为null吗，不行
     */
    @Test
    public void testMap() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        // 会抛NullPointerException
//        map.put(null, "abc");
        map.put("", "abc");
        System.out.println(map);
        System.out.println(map.get(""));

        // 会抛NullPointerException
//        map.put("a", null);
    }

    /**
     * 空map可以使用forEach吗，可以
     */
    @Test
    public void testForeach() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.clear();
//        map.put("a", "a");
        map.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }
}

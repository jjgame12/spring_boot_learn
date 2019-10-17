package com.java.learn;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
public class JavaBase {

    @Test
    public void test() {
        String a = null;
        System.out.println(a);

        String b = "";
        System.out.println(b == null);
    }

    @Test
    public void testConcurrentHashmap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        if (map.isEmpty()) {
            System.out.println("map is null. initial");
        }

        map.put("a", "1");
        map.put("b", "2");

        if (!map.isEmpty()) {
            System.out.println("map is not null.");
        }

        map.clear();
        if (map.isEmpty()) {
            System.out.println("map is cleared.");
        }
    }

    @Test
    public void testThread() {
        ThreadTest threadTest = new ThreadTest();
        new Thread(threadTest, "A").start();
        new Thread(threadTest, "B").start();
    }

    @Test
    public void testMap() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "111");
        map.put("b", "222");

        String key = "a";
        String result = map.containsKey(key) ? map.get(key) : "no key";
        System.out.println(result);

        key = "c";
        result = map.containsKey(key) ? map.get(key) : "no key";
        System.out.println(result);

        String value = map.get(key);
        System.out.println(null == value);

        value = null;
        key = "a";
        value = map.get(key);
        System.out.println(null == value);
    }
}

class ThreadTest implements Runnable {

    void syn() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("syn1");
            syn2();
        }
    }

    void syn2() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("syn2");
        }
    }

    @Override
    public void run() {
        syn();
    }
}


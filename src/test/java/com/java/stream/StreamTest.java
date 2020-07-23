package com.java.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    @Test
    public void testParallel() {
        List<Integer> ins = new ArrayList<>();
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 2000; i++) {
                ins.add(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 3000;i < 5000;i++) {
                ins.add(i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("e");
        }

        System.out.println(ins.size());
    }
}

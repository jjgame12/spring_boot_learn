package com.java.random;

import org.junit.Test;

import java.util.Random;

public class RandomTest {
    @Test
    public void test1() {
        Random random = new Random();

        Thread t1 = new Thread(() -> {
            for (int index = 0;index < 10;index++) {
                int i = random.nextInt(25);
                System.out.println("thread 1, i = " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int index = 0;index < 10;index++) {
                int j = random.nextInt(25);
                System.out.println("thread 2, j = " + j);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("thread is interrupted");
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}

package com.java.learn;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread {
    @Test
    public void test() {
        int times = 6000;
        ExecutorService pool = new ThreadPoolExecutor(1000, 1000, 100, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        CountDownLatch count = new CountDownLatch(times);
        for (int j = 0; j < times; j++) {
            pool.submit(new Inner(count));
        }

        try {
            count.await();
        } catch (InterruptedException e) {
            System.out.println("thread execution error...");
            e.printStackTrace();
            return;
        }

        System.out.println("result...i = " + Inner.i);
        System.out.println("result...atomicI = " + Inner.atomicInteger.get());
    }
}

class Inner implements Runnable {
    private CountDownLatch latch;
    static volatile int i = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public Inner(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        i++;
        atomicInteger.addAndGet(1);
        latch.countDown();
    }
}

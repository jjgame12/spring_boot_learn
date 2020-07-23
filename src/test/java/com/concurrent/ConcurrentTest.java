package com.concurrent;

import java.util.concurrent.*;

public class ConcurrentTest {
    public static void main(String[] args) {
        t2();
    }

    public static void t2() {
        FutureTask<String> future = new FutureTask<>(() -> {
            System.out.println("future");
            return "success";
        });
        Thread t = new Thread(future);
        t.start();
        try {
            System.out.println("t2 ---> " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("task ends");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0;i < 10;i++) {
            final int I = i;
            exec.execute(
                    () -> {
                        System.out.println("pool" + I);
                    }
            );
        }
        exec.shutdown();
    }

    public static void t1() {
        new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println("A" + i);
                if(i%10 == 0) Thread.yield();
            }
        }).start();

        new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println("------------B" + i);
                if(i%10 == 0) Thread.yield();
            }
        }).start();
    }
}

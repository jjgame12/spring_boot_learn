package com.java.multithread;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread name : " + Thread.currentThread().getName());
        Thread.sleep(500);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0;i < 3;i++) {
            Thread thread = new Thread(new Run1());
            threads.add(thread);
            thread.start();
        }

        System.out.println("main thread start new thread...");
        Thread.sleep(5000);
        System.out.println("after 5s ...");
        threads.get(0).interrupt();
    }
}

class Run1 implements Runnable {
    private static NormalLock lock = new NormalLock();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                System.out.println("nihao " + Thread.currentThread().getName());

                System.out.println("done " + Thread.currentThread().getName());

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("current thread " + Thread.currentThread().getName() + " is interrupted");
                    break;
                }

                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    System.out.println("interrupted...");
                    System.out.println("do other things...");
                    Thread.currentThread().interrupt(); // 再次记上中断标记位
//                    break;
                }
            }
//            Thread.yield();
        }
    }
}

class NormalLock {

}

package com.concurrent;

public class VolatileTest extends Thread {
    private static volatile boolean flag = false;
    private static int i = 0;

    public void run() {
        while (!flag) {
            flag = false;
        }

//        System.out.println("before i = " + i);
//        i++;
//        System.out.println("after i = " + i);
    }

    public static void main(String[] args) throws Exception {
        new VolatileTest().start();
        Thread.sleep(1000);
        flag = true;
//        for (int j = 0;j < 100;j++) {
//            VolatileTest t = new VolatileTest();
//            t.start();
//        }
//        System.out.println(i);
    }
}

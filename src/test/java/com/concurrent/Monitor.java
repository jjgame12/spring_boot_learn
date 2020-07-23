package com.concurrent;

public class Monitor {
    public static volatile Integer max = 100;

    public static void main(String[] args){
        Thread[] threads = new Thread[2];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true) {
                        if(max == null ){
                            max = 10;
                            System.out.println("已经被重置为null");
                        }
                    }
                }
            });
            threads[i].start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t1 = new Thread(){
            public void run(){
                while(true){
					System.out.println("重置中");
                    synchronized(this){
                        max = null;
                        System.out.println("重置done");
                    }
                }
            }
        };
        t1.start();
    }

}

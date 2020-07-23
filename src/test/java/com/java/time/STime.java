package com.java.time;

public class STime {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int i = (int)(l%100);
        System.out.println(i);
        System.out.println("a"+i);
    }
}

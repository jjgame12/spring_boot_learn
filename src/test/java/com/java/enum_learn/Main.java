package com.java.enum_learn;

public class Main {
    public static void main(String[] args) {
        System.out.println(WeekDay.valueOf("MONDAY"));
        System.out.println(WeekDay.SUNDAY.getValue());
    }
}

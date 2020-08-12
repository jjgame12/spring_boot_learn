package com.java.arrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Arr {
    @Test
    public void test1() {
        ArrayList<Integer> arr = new ArrayList<>(10);
        System.out.println(arr.size());
    }

    @Test
    public void test2() {
        List<A> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
    }

    @Test
    public void test3() {
        Byte a = 1;
        Byte b = 1;
        System.out.println(a.toString());
    }
}

class A {
    int id;
}

package com.java.base;

import org.junit.Test;

import java.util.List;

public class SplitTest {
    @Test
    public void testSplit() {
        String a = "19.1,2";
        String[] arr = a.split(",");
        System.out.println(arr.length);
    }

    @Test
    public void testString() {
        String str = "";
        str += "a";
        System.out.println(str);
    }
}

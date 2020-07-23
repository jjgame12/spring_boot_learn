package com.java.base;

import org.junit.Test;

public class StringTest {
    @Test
    public void teststr() {
        String str = "abcde";
        System.out.println(str.indexOf("cdx"));
    }

    @Test
    public void testEqual() {
        System.out.println("abc".equals(null));
    }
}

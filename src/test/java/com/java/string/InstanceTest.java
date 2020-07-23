package com.java.string;

import org.junit.Test;

public class InstanceTest {
    @Test
    public void test1() {
        String str = "hello,world";
        StringBuffer sb = new StringBuffer("hi,world");
        String str1 = str.replace('h','H');
        System.out.println(str);
        System.out.println(str1);

        sb.replace(0,2,"hello");
        System.out.println(sb);
    }
}

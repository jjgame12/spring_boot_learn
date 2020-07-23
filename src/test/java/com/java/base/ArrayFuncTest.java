package com.java.base;

import org.junit.Test;
import org.springframework.security.crypto.codec.Hex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayFuncTest {
    @Test
    public void testParamArray() {
        byte[] bytes = new byte[]{0xa, 0x10};
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(Hex.encode(bytes)));

        System.out.println("---------");
        byteLength(bytes);
    }

    private void byteLength(byte[] bytes) {
        System.out.println(bytes.length);
    }

    /**
     * 数组赋值是指针传递
     */
    @Test
    public void testArrayPointer() {
        int[] a = new int[]{1,2,3};

        int[] b = a;
        int[] c = new int[3];
        System.arraycopy(a, 0, c, 0, 3);


        a[0] = 10;
        System.out.println(a[0]);
        System.out.println(b[0]);
        System.out.println(c[0]);

        c = a;
        System.out.println(c[0]);
    }

    /**
     * stream foreach可以使用外部变量
     */
    @Test
    public void testStream() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "a");

        String[] strings = new String[]{"b", "c", "d", "e", "f"};
        Arrays.stream(strings).forEach(str -> {
            putStrTomap(str, map);
                }
        );

        map.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
    }

    private void putStrTomap(String str, ConcurrentHashMap<String, String> map) {
        map.put(str, str);
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);

        System.out.println(list.size());
//        list.get(0).length();

        System.out.println("a".equals(null));
    }

    @Test
    public void testContain() {
        List<String> arr = new ArrayList<>();
        arr.add("abc");
        arr.add("def");
        arr.add(null);

        System.out.println(arr.contains(null));
    }


}

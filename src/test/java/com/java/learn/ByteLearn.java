package com.java.learn;

import org.junit.Test;

public class ByteLearn {
    @Test
    public void testBytes() {
        byte[] bytes = "$adfsdffd".getBytes();
        System.out.println(bytes);

        byte[] bytes1 = new byte[]{(byte)0x97, (byte)0x99};
        System.out.println(bytes1);

        int[] ints = new int[]{1,2,3,4,5};
        System.out.println(ints);

    }
}

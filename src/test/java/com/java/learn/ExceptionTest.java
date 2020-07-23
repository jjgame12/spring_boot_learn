package com.java.learn;

import org.apache.dubbo.rpc.RpcException;
import org.junit.Test;

import java.io.IOException;

public class ExceptionTest {
    @Test
    public void testException() {
        Exception e = new Exception(new IOException());
//        e.initCause(new IOException());
        System.out.println(e.getCause());
    }

    @Test
    public void testTryException() {
        try {
            testTry();
        } catch (Exception e) {
            System.out.println("catch exception");
        }
    }

    public void testTry() throws Exception {
        try {
            throw new Exception();
        } finally {
            System.out.println("finally1...");
        }
    }
}

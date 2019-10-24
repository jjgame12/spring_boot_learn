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
}

package com.java.exception;

import org.junit.Test;

/**
 * 测试异常相关
 */
public class ExceptionTest {
    /**
     * 如果没有catch到的异常是否会被继续抛出，会的
     */
    @Test
    public void test2() {
        boolean ex = true;

        try {
            test1(ex);
        } catch (SecondException e) {
            System.out.println("Second Exception");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    /**
     * 如果没有catch到的异常是否会被继续抛出，会的
     */
    public void test1(boolean b) throws Exception {
        try {
            if (b) {
                throw new SecondException();
            }

            throw new FirstException();
        } catch (FirstException e) {
            System.out.println("First Exception");
        }
    }

    /**
     * 被抛出的异常会被再次捕捉吗，不会
     */
    @Test
    public void testThrow() throws Exception {
        try {
            throw new FirstException();
        } catch (FirstException e) {
            System.out.println("first exception");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}

class FirstException extends Exception {
    FirstException() {
        super();
    }
}

class SecondException extends Exception {
    SecondException() {
        super();
    }
}

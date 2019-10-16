package com.java.learn;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 注解可以保留到程序运行
@Documented
@Target(ElementType.TYPE)
public @interface TestAnnotation {
    int id();

    String msg();
}

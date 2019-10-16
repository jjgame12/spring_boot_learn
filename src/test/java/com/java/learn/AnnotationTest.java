/**
 * 本类主要用于学习java注解的相关例子
 */

package com.java.learn;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnnotationTest {

}

@TestAnnotation(id = 1, msg = "hello")
class TestAnnotationClass {

}

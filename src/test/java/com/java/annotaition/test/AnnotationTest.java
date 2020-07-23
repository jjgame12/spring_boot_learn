package com.java.annotaition.test;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 测试自定义注解的使用
 */
public class AnnotationTest {
    @Test
    public void testAnnot1() {
        Method[] methods = AnnotTest1.class.getDeclaredMethods();
        for (Method method : methods) {
            boolean hasAnnotation = method.isAnnotationPresent(Annot1.class);
            if (hasAnnotation) {
                System.out.println("method " + method.getName() + "() has Annot1: ");
                Annot1 annot1 = method.getAnnotation(Annot1.class);
                System.out.println("name = " + annot1.name() + " id = " + annot1.id() +
                        " cc = " + annot1.cc());
                System.out.println("--------------");
            }

            hasAnnotation = method.isAnnotationPresent(Annot2.class);
            if (!hasAnnotation) {
                System.out.println("method " + method.getName() + "() doesn't have Annot2 ");
                System.out.println("--------------");
            }

            Annot2 annot2 = method.getAnnotation(Annot2.class);
            System.out.println(annot2);
        }
    }
}


class AnnotTest1 {
    @Annot1(name = "go", cc = AnnotTest1.class)
    public void go() {}
}

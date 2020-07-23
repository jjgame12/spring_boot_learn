package com.java.reflect;

import lombok.Data;
import org.junit.Test;

public class ReflectTest {
    @Test
    public void testReflect() {
        Rf rf = new Rf();
        Class<?> c = rf.getClass();
        System.out.println(c);
    }
}

@Data
class Rf {
    private String a;
}

package com.java.base;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntegerTest {
    @Test
    public void testInteger() {
        Integer integer = null;
        // 会抛NullPointerException异常
        int i = integer;

        System.out.println("i = " + i);
    }

    @Test
    public void testA() {
        List<AA> aas = new ArrayList<>();
        AA a = new AA();
        a.setName("a");
        aas.add(a);
        a = new AA();
        a.setName("b");
        aas.add(a);
        System.out.println(aas.size());
        System.out.println(aas);
    }
}

@Data
class AA {
    private String name;
}

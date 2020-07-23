package com.java.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void testOption() {
        Integer i = null;
        try {
            Integer real = Optional.ofNullable(i).orElseThrow(() -> new Exception());
            System.out.println(real);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

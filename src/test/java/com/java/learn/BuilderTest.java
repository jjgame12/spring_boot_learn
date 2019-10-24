package com.java.learn;

import lombok.Data;
import org.junit.Test;

public class BuilderTest {
    @Test
    public void testBuild() {
        Wawa wawa = new Wawa.Builder().build();
        System.out.println(wawa.getId());
        System.out.println(wawa.getName());

        Wawa wawa1 = new Wawa.Builder()
                .id(2)
                .name("chenwawa")
                .build();
        System.out.println(wawa1.getId());
        System.out.println(wawa1.getName());
    }

}

@Data
class Wawa {
    private String name;
    private int id;

    public Wawa(Builder builder) {
        name = builder.name;
        id = builder.id;
    }

    public static void print() {
        System.out.println("print");
    }

    public static class Builder {
        private String name;
        private int id;

        public Builder() {
            name = "wawa";
            id = 1;
        }

        public Builder name(String nm) {
            name = nm;
            return this;
        }

        public Builder id(int i) {
            id = i;
            return this;
        }

        public Wawa build() {
            return new Wawa(this);
        }

    }
}

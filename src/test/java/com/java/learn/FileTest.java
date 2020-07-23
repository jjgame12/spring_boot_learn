package com.java.learn;

import org.junit.Test;

import java.io.File;

public class FileTest {
    public boolean mkdir(String path) {
        File file = null;
        try {
            file = new File(path);
        } catch (Exception e) {
            System.out.println("wrong");
        }

        if (!file.exists()) {
            return file.mkdirs();
        }

        return false;
    }

    @Test
    public void testMkdir() {
        String path = "/Users/jj/workspace/files/a.txt";
        System.out.println(mkdir(path));
    }
}

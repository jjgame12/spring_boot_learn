package com.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class RandomTest {
    @Test
    public void testCurrentTime() {
        long time = 0;
        for (int i = 0;i < 5;i++) {
            time = System.currentTimeMillis();
            String str = String.format("%010d", time % 100);
            log.info("random time = {}", time);
            log.info("random time = {}", String.format("%010d", time));
            log.info("random = {}", time % 100);
            log.info("random = {}", str);
        }
    }
}

package com.threadpool;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class ThreadPoolTest {
    @Autowired
    private ExecutorService pool;

    @Test
    public void testThread() {
        Future<String> future = pool.submit(new Task());
        try {
            log.info("result is {}", future.get());
        } catch (InterruptedException e) {
            log.error("interrupted: ", e);
        } catch (ExecutionException e) {
            log.error("execution: ", e);
        }

    }
}

class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "1";
    }
}

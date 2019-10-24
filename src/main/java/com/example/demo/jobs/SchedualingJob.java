package com.example.demo.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedualingJob {
    @Scheduled(fixedDelay = 1000)
    public void fixedJob1() {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >> fixDelay1...");
    }

    @Scheduled(fixedRate = 1500)
    public void fixedJob2() {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >> fixDelay2...");
    }

    @Scheduled(cron = "0 33 22 17 * ?")
    public void cronJob() {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >> fixDelay3...");
    }

}

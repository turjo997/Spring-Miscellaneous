package com.spring.spring_scheduler.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerServiceThree {

    @Scheduled(cron = "15 * * * * *")
    public void scheduledMethod() {
        System.out.println("Hello cron Scheduler Three :" +new Date());
    }
}

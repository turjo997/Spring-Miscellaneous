package com.spring.spring_scheduler.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerServiceTwo {

    @Scheduled(fixedRate = 1000)
    public void scheduledMethod() {
        System.out.println("Hello Scheduler Two :" +new Date());
    }
}

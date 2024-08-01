package com.spring.spring_scheduler.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerServiceOne {

    @Scheduled(initialDelay = 5000 , fixedDelay = 90000)
    public void ScheduleMethod(){
        System.out.println("Hello scheduler one : "+new Date());
    }
}

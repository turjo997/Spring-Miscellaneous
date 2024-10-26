package com.project.spring_bean_concepts.lifeCycle_annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MessageService {

    public MessageService() {
        System.out.println("Constructor: MessageService instance created.");
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct: Initializing MessageService.");
    }

    public void sendMessage(String message) {
        System.out.println("MessageService: Sending message - " + message);
    }


    @PreDestroy
    public void cleanup() {
        System.out.println("PreDestroy: Cleaning up MessageService.");
    }
}

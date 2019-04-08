package com.example.controller;

import com.example.producer.FirstSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SendController {

    @Autowired
    private FirstSender firstSender;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String send(String message) {
        String uuid = UUID.randomUUID().toString();
        for (int i = 1; i <= 1000; i++) {
            firstSender.sendMessage(uuid, message);
        }

        return uuid;
    }
}

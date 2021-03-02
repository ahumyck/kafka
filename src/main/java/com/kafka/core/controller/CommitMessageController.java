package com.kafka.core.controller;


import com.kafka.core.entity.User;
import com.kafka.core.request.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommitMessageController {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @PostMapping(value = "/pushMessage")
    public String pushMessage(@RequestBody UserMessage message) {
        String topic = message.getMessage().getTopic();
        kafkaTemplate.send(topic, new User(message));
        return "Published";
    }
}

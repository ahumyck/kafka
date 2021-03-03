package com.kafka.core.controller;

import com.kafka.core.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicReference;

@RestController
@Slf4j
public class MessageReaderController {

    private final AtomicReference<User> storedUser = new AtomicReference<>();

    @KafkaListener(topics = "KAFKA_TOPIC", groupId = "groupId",
            containerFactory = "userListener")
    public void storeUser(User user) {
        log.info("=> User: " + user);
        storedUser.set(user);
    }

    @GetMapping(value = "/pollMessage")
    public User getUser() {
        return storedUser.get();
    }
}

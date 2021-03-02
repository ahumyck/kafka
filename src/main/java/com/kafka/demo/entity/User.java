package com.kafka.demo.entity;

import com.kafka.demo.request.UserMessage;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long SerialVersionUID = -5769594765L;

    private String username;
    private Long salary;

    public User(UserMessage message) {
        this.username = message.getUsername();
        this.salary = message.getSalary();
    }
}

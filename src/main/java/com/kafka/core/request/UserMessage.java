package com.kafka.core.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {
    private RequestMessage message;
    private String username;
    private Long salary;
}

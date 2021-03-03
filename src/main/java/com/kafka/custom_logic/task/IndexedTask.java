package com.kafka.custom_logic.task;

import lombok.*;

@AllArgsConstructor
@Getter
public class IndexedTask {
    private final int index;
    private final double a;
    private final double b;
    private final double c;
}

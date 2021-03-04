package com.kafka.custom_logic.task;

import lombok.*;

import java.util.Random;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class IndexedTask {
    private int index;
    private int a;
    private int b;
    private int c;

    public static IndexedTask createRandomTask(int index) {
        Random random = new Random();
        return new IndexedTask(index, random.nextInt(25), random.nextInt(25), random.nextInt(25));
    }
}

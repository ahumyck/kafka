package com.kafka.custom_logic.task;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AbstractTaskGenerator implements TaskGenerator {

    private final AtomicInteger index = new AtomicInteger(0);

    @Override
    public IndexedTask produceTask() {
        return IndexedTask.createRandomTask(index.getAndIncrement());
    }

    @Override
    public List<IndexedTask> producesTasks(int howMany) {
        return IntStream
                .range(0, howMany)
                .mapToObj(i -> IndexedTask.createRandomTask(index.getAndIncrement()))
                .collect(Collectors.toList());
    }
}

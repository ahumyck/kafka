package com.kafka.custom_logic.task;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultTaskGenerator implements TaskGenerator {

    private final AtomicInteger index = new AtomicInteger(0);

    public IndexedTask produceTask() {
        return new IndexedTask(index.getAndIncrement(), 1, -3, 4);
    }

    @Override
    public List<IndexedTask> producesTasks(int howMany) {
        return IntStream
                .range(0, howMany)
                .mapToObj(i -> new IndexedTask(index.getAndIncrement(), 1, -3, 4))
                .collect(Collectors.toList());
    }
}

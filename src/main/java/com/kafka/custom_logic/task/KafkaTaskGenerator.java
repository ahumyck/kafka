package com.kafka.custom_logic.task;

import com.kafka.custom_logic.config.KafkaTaskProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class KafkaTaskGenerator implements TaskGenerator {

    private final KafkaTemplate<String, IndexedTask> kafkaTemplate;

    private final AtomicInteger index = new AtomicInteger(0);

    public KafkaTaskGenerator(KafkaTemplate<String, IndexedTask> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @PostMapping(value = "/produceTask")
    public IndexedTask produceTask() {
        IndexedTask indexedTask = new IndexedTask(index.getAndIncrement(), 1, -3, 4);
        kafkaTemplate.send(KafkaTaskProducer.TOPIC, indexedTask);
        return indexedTask;
    }

    @Override
    @PostMapping(value = "/produceTasks")
    public List<IndexedTask> producesTasks(@RequestParam int howMany) {
        return IntStream
                .range(0, howMany)
                .mapToObj(i -> {
                    IndexedTask indexedTask = new IndexedTask(index.getAndIncrement(), 1, -3, 4);
                    kafkaTemplate.send(KafkaTaskProducer.TOPIC, indexedTask);
                    return indexedTask;
                })
                .collect(Collectors.toList());
    }
}

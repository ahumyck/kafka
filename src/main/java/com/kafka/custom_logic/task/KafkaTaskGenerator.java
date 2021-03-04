package com.kafka.custom_logic.task;

import com.kafka.custom_logic.config.KafkaTaskProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaTaskGenerator extends AbstractTaskGenerator {

    private final KafkaTemplate<String, IndexedTask> kafkaTemplate;

    public KafkaTaskGenerator(KafkaTemplate<String, IndexedTask> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @PostMapping(value = "/produceTask")
    public IndexedTask produceTask() {
        IndexedTask indexedTask = super.produceTask();
        kafkaTemplate.send(KafkaTaskProducer.TOPIC, indexedTask);
        return indexedTask;
    }

    @Override
    @PostMapping(value = "/produceTasks")
    public List<IndexedTask> producesTasks(@RequestParam int howMany) {
        List<IndexedTask> indexedTasks = super.producesTasks(howMany);
        indexedTasks.forEach(task -> kafkaTemplate.send(KafkaTaskProducer.TOPIC, task));
        return indexedTasks;
    }
}

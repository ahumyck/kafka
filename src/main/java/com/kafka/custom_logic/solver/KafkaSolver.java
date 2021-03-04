package com.kafka.custom_logic.solver;

import com.kafka.custom_logic.answer.IndexedAnswer;
import com.kafka.custom_logic.config.KafkaAnswerProducer;
import com.kafka.custom_logic.config.KafkaTaskConsumer;
import com.kafka.custom_logic.config.KafkaTaskProducer;
import com.kafka.custom_logic.task.IndexedTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class KafkaSolver extends AbstractSolver {

    private final KafkaTemplate<String, IndexedAnswer> kafkaTemplate;


    public KafkaSolver(KafkaTemplate<String, IndexedAnswer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @KafkaListener(topics = KafkaTaskProducer.TOPIC, groupId = KafkaTaskConsumer.GROUP_ID,
            containerFactory = "taskListener")
    public IndexedAnswer solve(IndexedTask indexedTask) {
        log.info("=> Solving: " + indexedTask);
        IndexedAnswer solve = super.solve(indexedTask);
        log.info("=> KafkaSolver answer: " + solve);
        kafkaTemplate.send(KafkaAnswerProducer.TOPIC, solve);
        return solve;
    }
}

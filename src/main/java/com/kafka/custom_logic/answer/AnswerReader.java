package com.kafka.custom_logic.answer;

import com.kafka.custom_logic.config.KafkaAnswerConsumer;
import com.kafka.custom_logic.config.KafkaAnswerProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnswerReader {

    @KafkaListener(topics = KafkaAnswerProducer.TOPIC, groupId = KafkaAnswerConsumer.GROUP_ID,
            containerFactory = "answerListener")
    public IndexedAnswer consume(IndexedAnswer indexedAnswer) {
        log.info("=> AnswerReader answer: " + indexedAnswer);
        return indexedAnswer;
    }
}

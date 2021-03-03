package com.kafka.custom_logic.answer;

import com.kafka.custom_logic.config.KafkaAnswerConsumer;
import com.kafka.custom_logic.config.KafkaAnswerProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnswerReader {

//    @KafkaListener(topics = KafkaAnswerProducer.TOPIC, groupId = KafkaAnswerConsumer.GROUP_ID)
    public IndexedAnswer consume(IndexedAnswer indexedAnswer) {
        System.out.println(indexedAnswer);
        return indexedAnswer;
    }
}

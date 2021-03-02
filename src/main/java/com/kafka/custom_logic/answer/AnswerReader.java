package com.kafka.custom_logic.answer;

import com.kafka.custom_logic.IndexedObject;
import org.springframework.stereotype.Service;

@Service
public class AnswerReader {

	//	    @KafkaListener(topics = "KAFKA_TOPIC", groupId = "groupId") //TODO: change topic and group id
	public IndexedObject<Answer> consume(IndexedObject<Answer> indexedAnswer) {
		return indexedAnswer;
	}
}

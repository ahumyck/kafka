package com.kafka.custom_logic.task;

import com.kafka.custom_logic.IndexedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaTaskProducer {

	@Autowired
	KafkaTemplate<String, IndexedObject<Task>> kafkaTemplate;

	private final AtomicInteger index = new AtomicInteger(0);

	public IndexedObject<Task> produceTask() {
		IndexedObject<Task> indexedTask = new IndexedObject<>(index.getAndIncrement(), new Task(1, -3, 4));
		kafkaTemplate.send("topic", indexedTask); //TODO: change topic
		return indexedTask;
	}
}

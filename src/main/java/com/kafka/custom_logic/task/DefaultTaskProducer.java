package com.kafka.custom_logic.task;

import com.kafka.custom_logic.IndexedObject;

import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTaskProducer implements TaskProducer {

	private final AtomicInteger index = new AtomicInteger(0);

	public IndexedObject<Task> produceTask() {
		return new IndexedObject<>(index.getAndIncrement(), new Task(1, -3, 4));
	}
}

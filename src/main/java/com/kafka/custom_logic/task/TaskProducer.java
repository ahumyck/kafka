package com.kafka.custom_logic.task;

import com.kafka.custom_logic.IndexedObject;

public interface TaskProducer {

	IndexedObject<Task> produceTask();
}

package com.kafka.custom_logic.solver.impl.kafka;

import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.solver.AbstractSolver;
import com.kafka.custom_logic.answer.Answer;
import com.kafka.custom_logic.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSolver extends AbstractSolver {

	@Autowired
	private KafkaTemplate<String, IndexedObject<Answer>> kafkaTemplate;

	//	    @KafkaListener(topics = "KAFKA_TOPIC", groupId = "groupId")
	public IndexedObject<Answer> solve(IndexedObject<Task> indexedTask) {
		IndexedObject<Answer> solve = super.solve(indexedTask);
		kafkaTemplate.send("topic", solve);
		return solve;
	}

}

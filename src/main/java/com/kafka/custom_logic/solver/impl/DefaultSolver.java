package com.kafka.custom_logic.solver.impl;

import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.solver.AbstractSolver;
import com.kafka.custom_logic.answer.Answer;
import com.kafka.custom_logic.task.Task;
import lombok.SneakyThrows;


public class DefaultSolver extends AbstractSolver {

	@Override
	public IndexedObject<Answer> solve(IndexedObject<Task> indexedTask) {
		return super.solve(indexedTask);
	}
}

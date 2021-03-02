package com.kafka.custom_logic.solver;

import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.task.Answer;
import com.kafka.custom_logic.task.Task;

public interface Solver {
	IndexedObject<Answer> solve(IndexedObject<Task> indexedTask);
}

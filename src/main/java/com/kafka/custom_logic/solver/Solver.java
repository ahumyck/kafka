package com.kafka.custom_logic.solver;

import com.kafka.custom_logic.answer.IndexedAnswer;
import com.kafka.custom_logic.task.IndexedTask;

public interface Solver {
    IndexedAnswer solve(IndexedTask indexedTask);
}

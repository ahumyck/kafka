package com.kafka.custom_logic.solver.impl;

import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.solver.Solver;
import com.kafka.custom_logic.task.Answer;
import com.kafka.custom_logic.task.Task;
import lombok.SneakyThrows;

public class DefaultSolver implements Solver {

	@Override
	@SneakyThrows
	public IndexedObject<Answer> solve(IndexedObject<Task> indexedTask) {
		Task task = indexedTask.getObject();
		double a = task.getA();
		double b = task.getB();
		double c = task.getC();

		double D = b * b - 4 * a * c;
		Thread.sleep(10);
		if (D < 0) {
			return new IndexedObject<>(indexedTask.getIndex(), new Answer());
		} else if (D == 0) {
			double ans = -b / (2 * a);
			return new IndexedObject<>(indexedTask.getIndex(), new Answer(ans));
		} else {
			double sqrtD = Math.sqrt(D);
			double ans1 = (-b - sqrtD) / (2 * a);
			double ans2 = (-b + sqrtD) / (2 * a);
			return new IndexedObject<>(indexedTask.getIndex(), new Answer(ans1, ans2));
		}

	}
}

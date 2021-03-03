package com.kafka.custom_logic.solver;

import com.kafka.custom_logic.answer.IndexedAnswer;
import com.kafka.custom_logic.task.IndexedTask;
import lombok.SneakyThrows;

abstract public class AbstractSolver implements Solver {


    @SneakyThrows
    @Override
    public IndexedAnswer solve(IndexedTask task) {
        double a = task.getA();
        double b = task.getB();
        double c = task.getC();

        double D = b * b - 4 * a * c;
        Thread.sleep(10);
        if (D < 0) {
            return new IndexedAnswer(task.getIndex());
        } else if (D == 0) {
            double ans = -b / (2 * a);
            return new IndexedAnswer(task.getIndex(), ans);
        } else {
            double sqrtD = Math.sqrt(D);
            double ans1 = (-b - sqrtD) / (2 * a);
            double ans2 = (-b + sqrtD) / (2 * a);
            return new IndexedAnswer(task.getIndex(), ans1, ans2);
        }
    }
}

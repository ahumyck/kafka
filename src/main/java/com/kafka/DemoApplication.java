package com.kafka;

import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.solver.Solver;
import com.kafka.custom_logic.solver.impl.DefaultSolver;
import com.kafka.custom_logic.answer.Answer;
import com.kafka.custom_logic.task.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        int a = 1, b = -3, c = -4;
//        Solver solver = new DefaultSolver();
//        List<IndexedObject<Task>> tasks = IntStream
//                .range(0, 1000)
//                .mapToObj(i -> new IndexedObject<>(i, new Task(a, b, c)))
//                .collect(Collectors.toList());
//        long start = System.currentTimeMillis();
//        List<IndexedObject<Answer>> answers = tasks
//                .parallelStream()
//                .map(solver::solve)
//                .collect(Collectors.toList());
//        long end = System.currentTimeMillis();
//        System.out.println(answers);
//        System.out.println((end - start) + " ms");
    }

}

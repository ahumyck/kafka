package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

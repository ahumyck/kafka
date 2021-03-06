package com.kafka.custom_logic.answer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class IndexedAnswer {
    private int index;
    private List<Double> answers = new ArrayList<>();

    public IndexedAnswer(int index) {
        this.index = index;
    }

    public IndexedAnswer(int index, double x) {
        this.index = index;
        answers.add(x);
    }

    public IndexedAnswer(int index, double x1, double x2) {
        this.index = index;
        answers.add(x1);
        answers.add(x2);
    }
}

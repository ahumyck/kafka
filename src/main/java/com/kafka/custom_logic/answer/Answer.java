package com.kafka.custom_logic.answer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Answer {
	private List<Double> answers = new ArrayList<>();

	public Answer(double x) {
		answers.add(x);
	}

	public Answer(double x1, double x2) {
		answers.add(x1);
		answers.add(x2);
	}
}

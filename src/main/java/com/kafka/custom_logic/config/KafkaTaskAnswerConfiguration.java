package com.kafka.custom_logic.config;

import com.kafka.core.config.props.ProducerProperties;
import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.answer.Answer;
import com.kafka.custom_logic.task.Task;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
public class KafkaTaskAnswerConfiguration {

	@Bean
	public ProducerFactory<String, IndexedObject<Task>> taskProducerFactory() {

		Map<String, Object> properties = ProducerProperties
				.builder()
				.serverConfig("127.0.0.1:9092")
				.clientIdConfig("taskId")
				.keySerializer(StringSerializer.class)
				.valueSerializer(JsonSerializer.class)
				.build()
				.getAsMap();
		return new DefaultKafkaProducerFactory<>(properties);
	}

	@Bean
	public KafkaTemplate<String, IndexedObject<Task>> kafkaTaskTemplate() {
		return new KafkaTemplate<>(taskProducerFactory());
	}


	@Bean
	public ProducerFactory<String, IndexedObject<Answer>> answerProducerFactory() {

		Map<String, Object> properties = ProducerProperties
				.builder()
				.serverConfig("127.0.0.1:9092")
				.clientIdConfig("answerId")
				.keySerializer(StringSerializer.class)
				.valueSerializer(JsonSerializer.class)
				.build()
				.getAsMap();
		return new DefaultKafkaProducerFactory<>(properties);
	}

	@Bean
	public KafkaTemplate<String, IndexedObject<Answer>> kafkaAnswerTemplate() {
		return new KafkaTemplate<>(answerProducerFactory());
	}
}

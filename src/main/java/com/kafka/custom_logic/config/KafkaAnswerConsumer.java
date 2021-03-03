package com.kafka.custom_logic.config;

import com.kafka.core.config.props.ConsumerProperties;
import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.answer.Answer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

//@Configuration
public class KafkaAnswerConsumer {
//	@Bean
	public ConsumerFactory<String, IndexedObject<Answer>> answerConsumerFactory() {

		Map<String, Object> properties = ConsumerProperties
				.builder()
				.serverConfig("127.0.0.1:9092") //TODO: change
				.groupIdConfig("groupId") //TODO: change
				.keyDeserializer(StringDeserializer.class)
				.valueDeserializer(JsonDeserializer.class)
				.build()
				.getAsMap();

		return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(),
		                                         new JsonDeserializer<>(IndexedObject.class));
	}

//	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, IndexedObject<Answer>> answerListener() {
		ConcurrentKafkaListenerContainerFactory<String, IndexedObject<Answer>> listener
				= new ConcurrentKafkaListenerContainerFactory<>();
		listener.setConsumerFactory(answerConsumerFactory());
		return listener;
	}
}

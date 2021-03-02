package com.kafka.custom_logic.config;

import com.kafka.core.config.props.ConsumerProperties;
import com.kafka.custom_logic.IndexedObject;
import com.kafka.custom_logic.task.Task;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

public class KafkaTaskConsumer {

	@Bean
	public ConsumerFactory<String, IndexedObject<Task>> taskConsumerFactory() {

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

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, IndexedObject<Task>> taskListener() {
		ConcurrentKafkaListenerContainerFactory<String, IndexedObject<Task>> listener
				= new ConcurrentKafkaListenerContainerFactory<>();
		listener.setConsumerFactory(taskConsumerFactory());
		return listener;
	}

}

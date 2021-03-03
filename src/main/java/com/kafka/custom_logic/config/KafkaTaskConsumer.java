package com.kafka.custom_logic.config;

import com.kafka.core.config.props.ConsumerProperties;
import com.kafka.custom_logic.task.IndexedTask;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaTaskConsumer {

    public static final String GROUP_ID = "taskConsumerId";

    @Bean
    public ConsumerFactory<String, IndexedTask> taskConsumerFactory() {

        Map<String, Object> properties = ConsumerProperties
                .builder()
                .serverConfig("127.0.0.1:9092") //TODO: change
                .groupIdConfig(GROUP_ID) //TODO: change
                .keyDeserializer(StringDeserializer.class)
                .valueDeserializer(JsonDeserializer.class)
                .build()
                .getAsMap();
        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(),
                new JsonDeserializer<>(IndexedTask.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, IndexedTask> taskListener() {
        ConcurrentKafkaListenerContainerFactory<String, IndexedTask> listener
                = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(taskConsumerFactory());
        return listener;
    }

}

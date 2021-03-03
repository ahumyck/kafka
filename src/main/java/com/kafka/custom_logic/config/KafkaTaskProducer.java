package com.kafka.custom_logic.config;

import com.kafka.core.config.props.ProducerProperties;
import com.kafka.custom_logic.task.IndexedTask;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
public class KafkaTaskProducer {

    public static final String GROUP_ID = "taskProducerId";
    public static final String TOPIC = "TASKS_TOPIC";

    @Bean
    public ProducerFactory<String, IndexedTask> taskProducerFactory() {

        Map<String, Object> properties = ProducerProperties
                .builder()
                .serverConfig("127.0.0.1:9092") //TODO: change
                .clientIdConfig(GROUP_ID)
                .keySerializer(StringSerializer.class)
                .valueSerializer(JsonSerializer.class)
                .build()
                .getAsMap();
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, IndexedTask> kafkaTaskTemplate() {
        return new KafkaTemplate<>(taskProducerFactory());
    }
}

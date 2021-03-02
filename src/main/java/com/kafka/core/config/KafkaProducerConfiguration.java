package com.kafka.core.config;

import com.kafka.core.config.props.ProducerProperties;
import com.kafka.core.entity.User;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Bean
    public ProducerFactory<String, User> userProducerFactory() {

        Map<String, Object> properties = ProducerProperties
                .builder()
                .serverConfig("127.0.0.1:9092")
                .clientIdConfig("clientId")
                .keySerializer(StringSerializer.class)
                .valueSerializer(JsonSerializer.class)
                .build()
                .getAsMap();
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, User> kafkaUserTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}

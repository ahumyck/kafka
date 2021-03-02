package com.kafka.demo.config;

import com.kafka.demo.config.props.ConsumerProperties;
import com.kafka.demo.entity.User;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

    @Bean
    public ConsumerFactory<String, User> userConsumerFactory() {

        Map<String, Object> properties = ConsumerProperties
                .builder()
                .serverConfig("127.0.0.1:9092")
                .groupIdConfig("groupId")
                .keyDeserializer(StringDeserializer.class)
                .valueDeserializer(JsonDeserializer.class)
                .build()
                .getAsMap();

        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(),
                new JsonDeserializer<>(User.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> userListener() {
        ConcurrentKafkaListenerContainerFactory<String, User> listener
                = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(userConsumerFactory());
        return listener;
    }

    @Bean
    public ConsumerFactory<String, String> defaultConsumerFactory() {
        Map<String, Object> properties = ConsumerProperties
                .builder()
                .serverConfig("127.0.0.1:9092")
                .groupIdConfig("groupId")
                .keyDeserializer(StringDeserializer.class)
                .valueDeserializer(JsonDeserializer.class)
                .build()
                .getAsMap();
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> defaultListener() {
        ConcurrentKafkaListenerContainerFactory<String, String> listener
                = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(defaultConsumerFactory());
        return listener;
    }
}

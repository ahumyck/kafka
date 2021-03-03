package com.kafka.core.config;

import com.kafka.core.config.props.ConsumerProperties;
import com.kafka.core.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
@Slf4j
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
        log.info("user consumer factory => " + properties);
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
}

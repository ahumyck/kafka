package com.kafka.custom_logic.config;

import com.kafka.custom_logic.answer.IndexedAnswer;
import com.kafka.props.ConsumerProperties;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaAnswerConsumer {

    public static final String GROUP_ID = "answerConsumerId";

    @Bean
    public ConsumerFactory<String, IndexedAnswer> answerConsumerFactory() {

        Map<String, Object> properties = ConsumerProperties
                .builder()
                .serverConfig("127.0.0.1:9092") //TODO: change
                .groupIdConfig(GROUP_ID)
                .keyDeserializer(StringDeserializer.class)
                .valueDeserializer(JsonDeserializer.class)
                .build()
                .getAsMap();

        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(),
                new JsonDeserializer<>(IndexedAnswer.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, IndexedAnswer> answerListener() {
        ConcurrentKafkaListenerContainerFactory<String, IndexedAnswer> listener
                = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(answerConsumerFactory());
        return listener;
    }
}

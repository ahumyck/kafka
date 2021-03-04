package com.kafka.custom_logic.config;

import com.kafka.custom_logic.answer.IndexedAnswer;
import com.kafka.props.ProducerProperties;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@Configuration
public class KafkaAnswerProducer {

    public static final String GROUP_ID = "answerProducerId";
    public static final String TOPIC = "ANSWERS";

    @Bean
    public ProducerFactory<String, IndexedAnswer> answerProducerFactory() {

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
    public KafkaTemplate<String, IndexedAnswer> kafkaAnswerTemplate() {
        return new KafkaTemplate<>(answerProducerFactory());
    }
}

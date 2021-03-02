package com.kafka.core.config.props;

import lombok.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.HashMap;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConsumerProperties implements Mappable<String, Object> {

    private String serverConfig;
    private String groupIdConfig;
    private Class<?> keyDeserializer;
    private Class<?> valueDeserializer;

    @Override
    public Map<String, Object> getAsMap() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverConfig);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdConfig);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        return properties;
    }
}

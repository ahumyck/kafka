package com.kafka.core.config.props;

import lombok.*;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.HashMap;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProducerProperties implements Mappable<String, Object> {

    private String serverConfig;
    private String clientIdConfig;
    private Class<?> keySerializer;
    private Class<?> valueSerializer;

    @Override
    public Map<String, Object> getAsMap() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverConfig);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, clientIdConfig);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        return properties;
    }
}

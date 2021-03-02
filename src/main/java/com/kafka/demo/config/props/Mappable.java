package com.kafka.demo.config.props;

import java.util.Map;

public interface Mappable<K, V> {

    Map<K, V> getAsMap();

}

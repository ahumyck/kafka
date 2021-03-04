package com.kafka.props;

import java.util.Map;

public interface Mappable<K, V> {

    Map<K, V> getAsMap();

}

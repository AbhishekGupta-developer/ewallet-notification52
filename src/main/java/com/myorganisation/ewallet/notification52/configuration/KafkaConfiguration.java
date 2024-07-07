package com.myorganisation.ewallet.notification52.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    private Map<String, Object> getConsumerConfig() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return map;
    }

    @Bean
    public DefaultKafkaConsumerFactory<String, String> getKafkaConsumerFactory() {
        return new DefaultKafkaConsumerFactory<String, String>(getConsumerConfig());
    }

}

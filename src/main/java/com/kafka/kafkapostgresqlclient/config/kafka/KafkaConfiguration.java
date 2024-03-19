package com.kafka.kafkapostgresqlclient.config.kafka;

import com.kafka.kafkapostgresqlclient.model.kafka.post.Post;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaUrl;

    public Map<String, Object> consumerConfig() {
        var configs = new HashMap<String, Object>();

        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        configs.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        configs.put(JsonDeserializer.TYPE_MAPPINGS, "post:com.kafka.kafkapostgresqlclient.model.kafka.post.Post");

        return configs;
    }

    @Bean
    public ConsumerFactory<String, Post> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(Post.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Post> kafkaListenerContainerFactory() {
        var kafkaFactory = new ConcurrentKafkaListenerContainerFactory<String, Post>();
        kafkaFactory.setConsumerFactory(consumerFactory());
        return kafkaFactory;
    }
}

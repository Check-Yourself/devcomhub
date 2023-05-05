package com.devcomhub.userservice.config;

import com.devcomhub.userservice.utils.KafkaUtils;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ConditionalOnProperty("devcomhub.kafka-prop.producer.payment-sent.enabled")
@Configuration
public class WebPublisherServiceConsumerConfiguration {

    @Value("${devcomhub.kafka-prop.producer.payment-sent.topic}")
    private String topic;

    @Value("${devcomhub.kafka-prop.producer.payment-sent.initial-offset}")
    private Long initialOffset;

    @Value("${devcomhub.kafka-prop.schema-registry-url}")
    private String schemaRegistryUrl;

    @Value("${devcomhub.kafka-prop.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${devcomhub.kafka-prop.producer.payment-sent.group}")
    private String group;

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        // reset offsets if required
        Consumer<?, ?> consumer = factory.getConsumerFactory().createConsumer();
        KafkaUtils.resetKafkaTopicOffset(consumer, topic, initialOffset);

        consumer.close();
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        final Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, KafkaAvroDeserializer.class);
        config.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
        config.put(KafkaAvroDeserializerConfig.AUTO_REGISTER_SCHEMAS, false);
        config.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        return new DefaultKafkaConsumerFactory<>(config);
    }
}

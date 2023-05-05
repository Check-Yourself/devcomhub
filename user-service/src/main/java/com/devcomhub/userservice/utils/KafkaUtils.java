package com.devcomhub.userservice.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@UtilityClass
public class KafkaUtils {

    public static void resetKafkaTopicOffset(Consumer<?, ?> consumer, String topic, Long offset) {
        if (offset == null) {
            return;
        }
        Map<TopicPartition, OffsetAndMetadata> offsets = new LinkedHashMap<>();
        List<TopicPartition> topicPartitions = consumer.partitionsFor(topic)
                .stream()
                .map(i -> new TopicPartition(i.topic(), i.partition()))
                .toList();

        topicPartitions.forEach((p) -> offsets.put(p, new OffsetAndMetadata(offset)));
        if (!offsets.isEmpty()) {
            try {
                consumer.commitSync(offsets);
            } catch (Exception ignored) {
            }
        }
        consumer.partitionsFor(topic)
                .stream()
                .map(i -> new TopicPartition(i.topic(), i.partition()))
                .map(consumer::committed)
                .forEach(i -> System.out.println(i.offset()));
    }
}

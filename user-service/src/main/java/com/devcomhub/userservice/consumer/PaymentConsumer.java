package com.devcomhub.userservice.consumer;

import demo.kafka.event.PaymentSent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentConsumer {

    @KafkaListener(
            id = "web-publisher-service.topic",
            topics = "${devcomhub.kafka-prop.producer.payment-sent.topic}",
            groupId = "${devcomhub.kafka-prop.producer.payment-sent.group}",
            containerGroup = "${devcomhub.kafka-prop.producer.payment-sent.group}",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(
            @Header(KafkaHeaders.RECEIVED_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.OFFSET) String offset,
            @Payload final PaymentSent payLoad) {
        log.info(String.format("Received message: {topic=%s offset=%s key=%s}", topic, offset, key));
        //
    }
}

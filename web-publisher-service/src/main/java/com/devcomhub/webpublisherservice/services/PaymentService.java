package com.devcomhub.webpublisherservice.services;

import com.devcomhub.webpublisherservice.dto.PaymentSendRequest;
import com.devcomhub.webpublisherservice.libs.KafkaClient;
import demo.kafka.event.PaymentSent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private final KafkaClient kafkaClient;

    /**
     * Called via REST request.
     */
    public void process(String key, PaymentSendRequest request) {
        PaymentSent outboundEvent = PaymentSent.newBuilder()
                .setPaymentId(request.getPaymentId())
                .setAmount(request.getAmount())
                .setCurrency(request.getCurrency())
                .setFromAccount(request.getFromAccount())
                .setToAccount(request.getToAccount())
                .build();
        kafkaClient.sendMessage(key, outboundEvent);
    }
}

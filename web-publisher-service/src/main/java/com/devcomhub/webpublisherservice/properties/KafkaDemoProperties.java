package com.devcomhub.webpublisherservice.properties;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component
@ConfigurationProperties("devcomhub.kafka-prop.producer.payment-sent")
@Data
@Validated
public class KafkaDemoProperties {
    @NotNull
    private String topic;
}

package com.devcomhub.webpublisherservice.properties;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;


@Configuration
@ConfigurationProperties("devcomhub.kafka-prop.producer.payment-sent")
@Getter
@Setter
@Validated
public class KafkaDemoProperties {
    @NotNull
    private String topic;
}

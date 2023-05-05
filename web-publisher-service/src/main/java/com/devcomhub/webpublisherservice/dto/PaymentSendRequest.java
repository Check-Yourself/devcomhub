package com.devcomhub.webpublisherservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PaymentSendRequest {
    private String paymentId;
    private Double amount;
    private String currency;
    private String fromAccount;
    private String toAccount;
}

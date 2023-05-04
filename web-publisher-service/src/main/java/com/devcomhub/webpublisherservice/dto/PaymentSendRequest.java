package com.devcomhub.webpublisherservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSendRequest {
    private String paymentId;
    private Double amount;
    private String currency;
    private String fromAccount;
    private String toAccount;
}

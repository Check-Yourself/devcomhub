package com.devcomhub.webpublisherservice.dto;

import lombok.Data;

@Data
public class PaymentSendRequest {
    private String paymentId;
    private Double amount;
    private String currency;
    private String fromAccount;
    private String toAccount;
}

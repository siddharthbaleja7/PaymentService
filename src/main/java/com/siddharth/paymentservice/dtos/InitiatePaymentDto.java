package com.siddharth.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentDto {
    private Long orderId;
    private String email;
    private Integer amount;
}

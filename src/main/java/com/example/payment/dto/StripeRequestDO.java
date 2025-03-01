package com.example.payment.dto;

import lombok.Data;

@Data
public class StripeRequestDO {

    private String name;
    private String description;
    private String currency;
    private long amount;
    private long quantity;
}

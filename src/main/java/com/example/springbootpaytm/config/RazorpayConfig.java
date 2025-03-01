package com.example.springbootpaytm.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("razorpay")
public class RazorpayConfig {

    private String keyId;
    private String keySecret;

}

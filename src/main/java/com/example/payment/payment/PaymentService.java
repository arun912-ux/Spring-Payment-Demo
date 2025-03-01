package com.example.payment.payment;

import com.example.payment.dto.StripeRequestDO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentService {


    public PaymentService(@Value("${stripe.secret-key}") String stripeSecretKey) {
        Stripe.apiKey = stripeSecretKey;
    }

    public String stripeCheckout(StripeRequestDO stripeRequestDO) {

        SessionCreateParams.LineItem.PriceData.ProductData productData = SessionCreateParams.LineItem.PriceData.ProductData.builder()
                .setName(stripeRequestDO.getName())
                .setDescription(stripeRequestDO.getDescription())
                .build();

        SessionCreateParams.LineItem.PriceData priceData = SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency(stripeRequestDO.getCurrency())
                .setProductData(productData)
                .setUnitAmount(stripeRequestDO.getAmount())
                .build();

        SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                .setPriceData(priceData)
                .setQuantity(stripeRequestDO.getQuantity())
                .build();

        SessionCreateParams sessionCreateParams = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .addAllLineItem(List.of(lineItem))
                .setSuccessUrl("https://example.com")
                .build();

        Session session = null;
        try {
            session = Session.create(sessionCreateParams);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
        log.info("session: {}", session);

        return session.getUrl();
    }

}

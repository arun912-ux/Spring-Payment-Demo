package com.example.payment.controller;

import com.example.payment.dto.StripeRequestDO;
import com.example.payment.payment.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class HomeController {

    private final PaymentService paymentService;

    public HomeController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/stripe")
    public ResponseEntity stripeRequest(@RequestBody StripeRequestDO stripeRequestDO) {
        String checkoutUrl = paymentService.stripeCheckout(stripeRequestDO);
        return ResponseEntity.ok(checkoutUrl);
    }

    @PostMapping("/razorpay")
    public ResponseEntity razorpayRequest() {
        return ResponseEntity.ok().build();
    }

}

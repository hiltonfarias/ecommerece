package com.hiltonfarias.ecommerce.checkout.listener;

import com.hiltonfarias.ecommerce.checkout.service.CheckoutService;
import com.hiltonfarias.ecommerce.checkout.streaming.PaymentPaidSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler() {

    }
}

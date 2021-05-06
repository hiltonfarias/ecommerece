package com.hiltonfarias.ecommerce.payment.listener;

import com.hiltonfarias.ecommerce.payment.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent) {
        // Processa pagamento gateway
        // salvar os dados do pagamento
        // enviar o evento processado
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(checkoutCreatedEvent.getCheckoutCode())
                .setCheckoutStatus(checkoutCreatedEvent.getStatus())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();
        checkoutCreatedEvent.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}

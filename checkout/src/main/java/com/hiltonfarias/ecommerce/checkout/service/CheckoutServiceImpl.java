package com.hiltonfarias.ecommerce.checkout.service;

import com.hiltonfarias.ecommerce.checkout.entity.CheckoutEntity;
import com.hiltonfarias.ecommerce.checkout.repository.CheckoutRepository;
import com.hiltonfarias.ecommerce.checkout.resource.checkout.CheckoutRequest;
import com.hiltonfarias.ecommerce.checkout.streaming.CheckoutCreatedSource;
import com.hiltonfarias.ecommerce.checkout.util.UUIDUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;
    private final UUIDUtil uuidUtil;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        log.info("M=create, checkoutRequest={}", checkoutRequest);
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(uuidUtil.createUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);

//        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
//                .setCheckoutCode(entity.getCode())
//                .setStatus(entity.getStatus().name())
//                .build();
//        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(entity);
    }

    @Override
    public Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status) {
        final CheckoutEntity checkoutEntity = checkoutRepository
                .findByCode(checkoutCode)
                .orElse(CheckoutEntity.builder().build());
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}

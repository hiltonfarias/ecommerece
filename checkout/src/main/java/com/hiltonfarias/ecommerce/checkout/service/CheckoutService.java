package com.hiltonfarias.ecommerce.checkout.service;

import com.hiltonfarias.ecommerce.checkout.entity.CheckoutEntity;
import com.hiltonfarias.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {
    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}

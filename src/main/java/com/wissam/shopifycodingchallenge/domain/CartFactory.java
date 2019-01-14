package com.wissam.shopifycodingchallenge.domain;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartFactory {

    public CartFactory() {}

    private String generateCartId() {
        return UUID.randomUUID().toString();
    }

    public Cart createCart() {
        return new Cart(generateCartId());
    }
}

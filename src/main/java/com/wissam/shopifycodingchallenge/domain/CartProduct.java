package com.wissam.shopifycodingchallenge.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartProduct {

    @Id
    @GeneratedValue
    private String id;

    private String productId;

    private String cartId;
}

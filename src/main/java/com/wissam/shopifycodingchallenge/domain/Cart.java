package com.wissam.shopifycodingchallenge.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    public Cart() {
        //for Hibernate
    }

    @Id
    private String id;

    @OneToMany
    @JoinColumn
    private List<CartProduct> products;

    public Cart(String id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public void addProduct(CartProduct product) {
        this.products.add(product);
    }

    public String getId() {
        return id;
    }

    public List<CartProduct> getProducts() {
        return products;
    }
}

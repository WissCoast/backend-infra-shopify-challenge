package com.wissam.shopifycodingchallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn
    private List<CartProduct> products;

    private Long totalCartValue;

    public Cart(String id) {
        this.id = id;
        this.products = new ArrayList<>();
        this.totalCartValue = 0L;
    }

    public void addProduct(CartProduct newCartProduct) {
        //checks if the product already exists in the cart, if so, then the quantity is updated
        for (CartProduct cartProduct : products) {
            if (cartProduct.getProductId().equals(newCartProduct.getProductId())) {
                cartProduct.setQuantity(cartProduct.getQuantity() + newCartProduct.getQuantity());
                return;
            }
        }
        this.products.add(newCartProduct);
    }

    //value can be positive or negative
    public void updateCartValue(Long value) {
        totalCartValue = totalCartValue + value;
    }

    public String getId() {
        return id;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public Long getTotalCartValue() {
        return totalCartValue;
    }
}

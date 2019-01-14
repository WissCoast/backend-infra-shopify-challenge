package com.wissam.shopifycodingchallenge.services;

import com.wissam.shopifycodingchallenge.domain.Cart;
import com.wissam.shopifycodingchallenge.domain.CartFactory;
import com.wissam.shopifycodingchallenge.domain.exceptions.CartNotFoundException;
import com.wissam.shopifycodingchallenge.persistence.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final CartFactory cartFactory;

    @Autowired
    public CartService(CartRepository cartRepository, CartFactory cartFactory) {
        this.cartRepository = cartRepository;
        this.cartFactory = cartFactory;
    }

    public String createCart() {
        Cart cart = cartFactory.createCart();
        cartRepository.save(cart);
        return cart.getId();
    }

    public void addProduct(String id) {
        Cart cart = cartRepository.findCartById(id);
        if (cart == null) {
            throw new CartNotFoundException(id);
        }
    }
}

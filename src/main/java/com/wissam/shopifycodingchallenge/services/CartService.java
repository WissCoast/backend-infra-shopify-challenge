package com.wissam.shopifycodingchallenge.services;

import com.wissam.shopifycodingchallenge.domain.Cart;
import com.wissam.shopifycodingchallenge.domain.CartFactory;
import com.wissam.shopifycodingchallenge.domain.CartProduct;
import com.wissam.shopifycodingchallenge.domain.Product;
import com.wissam.shopifycodingchallenge.domain.exceptions.CartNotFoundException;
import com.wissam.shopifycodingchallenge.domain.exceptions.ProductNotFoundException;
import com.wissam.shopifycodingchallenge.persistence.repositories.CartRepository;
import com.wissam.shopifycodingchallenge.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartFactory cartFactory;

    @Autowired
    public CartService(CartRepository cartRepository, CartFactory cartFactory, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartFactory = cartFactory;
    }

    public String createCart() {
        Cart cart = cartFactory.createCart();
        cartRepository.save(cart);
        return cart.getId();
    }

    public void addProduct(String cartId, String productId) {
        Cart cart = cartRepository.findCartById(cartId);
        if (cart == null) {
            throw new CartNotFoundException(cartId);
        }
        Product product = productRepository.findProductById(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        cart.addProduct(new CartProduct(productId, cartId));
        cartRepository.save(cart);
    }

}

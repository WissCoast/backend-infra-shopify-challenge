package com.wissam.shopifycodingchallenge.controllers;

import com.wissam.shopifycodingchallenge.domain.exceptions.ProductApiException;
import com.wissam.shopifycodingchallenge.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/")
    public String createCart() {
        return cartService.createCart();
    }

    @PostMapping("/{cartId}/product/{productId}")
    public ResponseEntity<Object> addProduct(@PathVariable("cartId") String cartId,
                                             @PathVariable("productId") String productId) {
        try {
            cartService.addProduct(cartId, productId);
        } catch (ProductApiException e) {
            return new ResponseEntity<>(e.generateErrorMessage(), e.getHttpStatus());
        }
        return ResponseEntity.accepted().build();
    }
}

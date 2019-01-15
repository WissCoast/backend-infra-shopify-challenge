package com.wissam.shopifycodingchallenge.controllers;

import com.wissam.shopifycodingchallenge.domain.exceptions.ProductApiException;
import com.wissam.shopifycodingchallenge.persistence.repositories.CartProductRepository;
import com.wissam.shopifycodingchallenge.persistence.repositories.ProductRepository;
import com.wissam.shopifycodingchallenge.domain.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public String createCart() {
        return cartService.createCart();
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Object> getCartInfo(@PathVariable("cartId") String cartId) {
        return new ResponseEntity<>(cartService.getCartDto(cartId), HttpStatus.FOUND);
    }

    @PostMapping("/{cartId}/product/{productId}")
    public ResponseEntity<Object> addProduct(@PathVariable("cartId") String cartId,
                                             @PathVariable("productId") String productId,
                                             @RequestParam(name = "quantity", defaultValue = "1") Long quantity) {
        try {
            cartService.addProduct(cartId, productId, quantity);
        } catch (ProductApiException e) {
            return new ResponseEntity<>(e.generateErrorMessage(), e.getHttpStatus());
        }
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/{cartId}/complete")
    public ResponseEntity<Object> completeCart(@PathVariable("cartId") String cartId) {
        try {
            cartService.completeCart(cartId);
        } catch (ProductApiException e) {
            return new ResponseEntity<>(e.generateErrorMessage(), e.getHttpStatus());
        }
        return ResponseEntity.accepted().build();
    }
}

package com.wissam.shopifycodingchallenge.controllers;

import com.wissam.shopifycodingchallenge.domain.CartProduct;
import com.wissam.shopifycodingchallenge.domain.Product;
import com.wissam.shopifycodingchallenge.domain.exceptions.ProductApiException;
import com.wissam.shopifycodingchallenge.domain.exceptions.ProductOutOfStockException;
import com.wissam.shopifycodingchallenge.persistence.repositories.CartProductRepository;
import com.wissam.shopifycodingchallenge.persistence.repositories.ProductRepository;
import com.wissam.shopifycodingchallenge.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final CartProductRepository cartProductRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartController(CartService cartService,
                          CartProductRepository cartProductRepository,
                          ProductRepository productRepository) {
        this.cartService = cartService;
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/")
    public String createCart() {
        return cartService.createCart();
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

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable("cartId") String cartId) {

    }

    @DeleteMapping("/{cartId}/product/{productId}")
    public void deleteCartItem(@PathVariable("cartId") String cartId,
                               @PathVariable("productId") String productId) {

    }
}

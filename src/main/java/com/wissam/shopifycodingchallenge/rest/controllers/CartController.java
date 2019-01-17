package com.wissam.shopifycodingchallenge.rest.controllers;

import com.wissam.shopifycodingchallenge.domain.exceptions.ProductApiException;
import com.wissam.shopifycodingchallenge.rest.dto.response.CartDto;
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
    public ResponseEntity<String> createCart() {
        return new ResponseEntity<>(cartService.createCart(), HttpStatus.CREATED);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity getCartInfo(@PathVariable("cartId") String cartId) {
        CartDto cartDto;
        try {
            cartDto = cartService.getCartDto(cartId);
        } catch (ProductApiException e) {
            return new ResponseEntity<>(e.generateErrorMessage(), e.getHttpStatus());
        }
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @PostMapping("/{cartId}/product/{productId}")
    public ResponseEntity addProduct(@PathVariable("cartId") String cartId,
                                             @PathVariable("productId") String productId,
                                             @RequestParam(name = "quantity", defaultValue = "1") Long quantity) {
        CartDto cartDto;
        try {
            cartDto = cartService.addProduct(cartId, productId, quantity);
        } catch (ProductApiException e) {
            return new ResponseEntity<>(e.generateErrorMessage(), e.getHttpStatus());
        }
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @PostMapping("/{cartId}/complete")
    public ResponseEntity completeCart(@PathVariable("cartId") String cartId) {
        try {
            cartService.completeCart(cartId);
        } catch (ProductApiException e) {
            return new ResponseEntity<>(e.generateErrorMessage(), e.getHttpStatus());
        }
        return ResponseEntity.ok().build();
    }
}

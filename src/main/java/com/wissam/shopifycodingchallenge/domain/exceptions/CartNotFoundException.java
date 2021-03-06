package com.wissam.shopifycodingchallenge.domain.exceptions;

import org.springframework.http.HttpStatus;

public class CartNotFoundException extends ProductApiException {

    private final static String ERROR_MESSAGE = "Cart with id %s not found";
    private final static HttpStatus ERROR_CODE = HttpStatus.NOT_FOUND;

    public CartNotFoundException(String cartId) {
        super();
        this.setErrorMessage(String.format(ERROR_MESSAGE, cartId));
        this.setHttpStatus(ERROR_CODE);
    }
}

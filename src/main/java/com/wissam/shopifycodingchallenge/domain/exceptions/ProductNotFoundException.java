package com.wissam.shopifycodingchallenge.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ProductApiException {

    private final static String ERROR_MESSAGE = "Product with id %s not found";
    private final static HttpStatus ERROR_CODE = HttpStatus.NOT_FOUND;

    public ProductNotFoundException(String productId) {
        super();
        this.setErrorMessage(String.format(ERROR_MESSAGE, productId));
        this.setHttpStatus(ERROR_CODE);
    }
}

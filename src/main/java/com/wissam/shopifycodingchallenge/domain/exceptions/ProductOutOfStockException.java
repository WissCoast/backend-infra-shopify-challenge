package com.wissam.shopifycodingchallenge.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ProductOutOfStockException extends ProductApiException {
    private final static String ERROR_MESSAGE = "Shopping cart quantity is higher than inventory stock for product with name %s";
    private final static HttpStatus ERROR_CODE = HttpStatus.BAD_REQUEST;

    public ProductOutOfStockException(String productTitle) {
        super();
        this.setErrorMessage(String.format(ERROR_MESSAGE, productTitle));
        this.setHttpStatus(ERROR_CODE);
    }
}

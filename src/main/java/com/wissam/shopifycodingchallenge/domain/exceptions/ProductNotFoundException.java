package com.wissam.shopifycodingchallenge.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ProductApiException {

    private final static String ERROR_MESSAGE_ID = "Product with id %s not found";
    private final static String ERROR_MESSAGE_TITLE = "Product with title %s not found";
    private final static HttpStatus ERROR_CODE = HttpStatus.NOT_FOUND;

    public ProductNotFoundException(String searchCriteria, boolean searchByTitle) {
        super();
        this.setErrorMessage(String.format(ERROR_MESSAGE_ID, searchCriteria));
        if (searchByTitle) {
            this.setErrorMessage(String.format(ERROR_MESSAGE_TITLE, searchCriteria));
        }
        this.setHttpStatus(ERROR_CODE);
    }
}

package com.wissam.shopifycodingchallenge.domain.exceptions;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class ProductApiException extends RuntimeException {

    private String errorMessage;

    private HttpStatus httpStatus;

    public ProductApiException() {
        super();
    }

    public String generateErrorMessage() {
        JSONObject responseJson = new JSONObject();
        responseJson.put("errorMessage", errorMessage);
        return responseJson.toString();
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}

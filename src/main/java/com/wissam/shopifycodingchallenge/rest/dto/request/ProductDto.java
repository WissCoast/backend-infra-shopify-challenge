package com.wissam.shopifycodingchallenge.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {

    @JsonProperty
    public String title;
    @JsonProperty
    public Long price;
    @JsonProperty
    public Long inventoryCount;

}

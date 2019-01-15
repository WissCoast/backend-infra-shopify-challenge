package com.wissam.shopifycodingchallenge.controllers.assemblers;

import com.wissam.shopifycodingchallenge.controllers.dto.CartProductDto;
import com.wissam.shopifycodingchallenge.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler {

    public CartProductDto toDto(Product product, Long quantity) {
        CartProductDto cartProductDto = new CartProductDto();

        cartProductDto.id = product.getId();
        cartProductDto.title = product.getTitle();
        cartProductDto.price = product.getPrice();
        cartProductDto.quantity = quantity;

        return cartProductDto;
    }
}

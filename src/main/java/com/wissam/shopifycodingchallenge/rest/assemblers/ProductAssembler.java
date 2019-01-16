package com.wissam.shopifycodingchallenge.rest.assemblers;

import com.wissam.shopifycodingchallenge.domain.Product;
import com.wissam.shopifycodingchallenge.rest.dto.request.ProductDto;
import com.wissam.shopifycodingchallenge.rest.dto.response.CartProductDto;
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

    public Product fromDto(ProductDto productDto) {
        return new Product(productDto.title, productDto.price, productDto.inventoryCount);
    }
}

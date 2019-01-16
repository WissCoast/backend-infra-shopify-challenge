package com.wissam.shopifycodingchallenge.services;

import com.google.common.collect.Lists;
import com.wissam.shopifycodingchallenge.domain.Product;
import com.wissam.shopifycodingchallenge.persistence.repositories.ProductRepository;
import com.wissam.shopifycodingchallenge.rest.assemblers.ProductAssembler;
import com.wissam.shopifycodingchallenge.rest.dto.request.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductAssembler productAssembler;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ProductAssembler productAssembler) {
        this.productRepository = productRepository;
        this.productAssembler = productAssembler;
    }

    public List<Product> findAllProducts(boolean available) {
        if (available) {
            return productRepository.findAllAvailableProducts();
        }
        return Lists.newArrayList(productRepository.findAll());
    }

    public Product findProductByTitle(String title) {
        return productRepository.findProductByTitle(title);
    }

    public Product addProduct(ProductDto productDto) {
        Product product = productAssembler.fromDto(productDto);
        productRepository.save(product);
        return product;
    }
}

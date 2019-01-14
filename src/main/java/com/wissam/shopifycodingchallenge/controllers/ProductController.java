package com.wissam.shopifycodingchallenge.controllers;

import com.google.common.collect.Lists;
import com.wissam.shopifycodingchallenge.domain.Product;
import com.wissam.shopifycodingchallenge.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Product> findAllProducts(@RequestParam(name = "available", defaultValue = "false") boolean available) {
        if (available) {
            return productRepository.findAllAvailableProducts();
        }
        return Lists.newArrayList(productRepository.findAll());
    }

    @GetMapping({"/{title}"})
    public Product findByTitle(@PathVariable("title") String title) {
        return productRepository.findProductByTitle(title);
    }

    @GetMapping("/test")
    public String addOne(){
        productRepository.save(new Product("item", 10000L, 10L));
        return "success";
    }
}

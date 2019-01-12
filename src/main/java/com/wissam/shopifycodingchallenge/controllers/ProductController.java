package com.wissam.shopifycodingchallenge.controllers;

import com.google.common.collect.Lists;
import com.wissam.shopifycodingchallenge.persistence.entities.Product;
import com.wissam.shopifycodingchallenge.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String get() {
        return "nice";
    }

    @GetMapping("/all")
    public List<Product> findAllProducts(@RequestParam(name = "available", defaultValue = "false") boolean available) {
        if (available) {
            return productRepository.findAllAvailableProducts();
        }
        return Lists.newArrayList(productRepository.findAll());
    }

    @GetMapping({"/{title}"})
    public Product findByTitle(@PathParam("title") String title) {
        return productRepository.findProductByTitle(title);
    }

    @GetMapping("/test")
    public String saveSth(){
        productRepository.save(new Product("urmom", 10000L, 10L));
        return "success";
    }
}

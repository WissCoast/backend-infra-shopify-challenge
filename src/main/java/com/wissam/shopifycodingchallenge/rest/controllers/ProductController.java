package com.wissam.shopifycodingchallenge.rest.controllers;

import com.wissam.shopifycodingchallenge.domain.Product;
import com.wissam.shopifycodingchallenge.rest.dto.request.ProductDto;
import com.wissam.shopifycodingchallenge.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(name = "available", defaultValue = "false") boolean available) {
        return new ResponseEntity<>(productService.findAllProducts(available), HttpStatus.OK);
    }

    @GetMapping( {"/{title}"})
    public ResponseEntity getProductByTitle(@PathVariable("title") String title) {
        return new ResponseEntity<>(productService.findProductByTitle(title), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addOne(@RequestBody ProductDto productDto) {
        Product product = productService.addProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}

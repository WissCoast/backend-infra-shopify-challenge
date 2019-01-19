package com.wissam.shopifycodingchallenge.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public ResponseEntity welcome() {
        return ResponseEntity.ok().body("Hello! Thank you for checking my app. Api documentation is available here: https://github.com/WissCoast/backend-infra-shopify-challenge/blob/master/api_documentation.md");
    }
}

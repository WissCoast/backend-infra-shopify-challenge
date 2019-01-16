package com.wissam.shopifycodingchallenge.persistence.repositories;


import com.wissam.shopifycodingchallenge.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    Product findProductById(String id);

    Product findProductByTitle(String title);

    @Query("SELECT p FROM Product p WHERE p.inventoryCount > 0")
    List<Product> findAllAvailableProducts();
}

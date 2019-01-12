package com.wissam.shopifycodingchallenge.persistence.repositories;


import com.wissam.shopifycodingchallenge.persistence.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("unused")
public interface ProductRepository extends CrudRepository<Product, String> {

    Product findProductByTitle(@Param("title") String title);

    List<Product> findProductByPrice(int price);

    @Query("SELECT p FROM Product p WHERE p.inventoryCount > 0")
    List<Product> findAllAvailableProducts();

}

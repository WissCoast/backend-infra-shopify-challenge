package com.wissam.shopifycodingchallenge.persistence.repositories;

import com.wissam.shopifycodingchallenge.domain.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, String> {

    Cart findCartById(String id);
}

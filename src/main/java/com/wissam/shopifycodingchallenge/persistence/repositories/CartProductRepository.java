package com.wissam.shopifycodingchallenge.persistence.repositories;

import com.wissam.shopifycodingchallenge.domain.CartProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartProductRepository extends CrudRepository<CartProduct, String> {

    @Query("select p from CartProduct p WHERE p.cartId = :cartId")
    List<CartProduct> findCartProductsByCartId(@Param("cartId") String cartId);

    void deleteCartProductsByCartId(String id);
}
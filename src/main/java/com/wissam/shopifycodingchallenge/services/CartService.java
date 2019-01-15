package com.wissam.shopifycodingchallenge.services;

import com.wissam.shopifycodingchallenge.domain.Cart;
import com.wissam.shopifycodingchallenge.domain.CartFactory;
import com.wissam.shopifycodingchallenge.domain.CartProduct;
import com.wissam.shopifycodingchallenge.domain.Product;
import com.wissam.shopifycodingchallenge.domain.exceptions.CartNotFoundException;
import com.wissam.shopifycodingchallenge.domain.exceptions.ProductNotFoundException;
import com.wissam.shopifycodingchallenge.domain.exceptions.ProductOutOfStockException;
import com.wissam.shopifycodingchallenge.persistence.repositories.CartProductRepository;
import com.wissam.shopifycodingchallenge.persistence.repositories.CartRepository;
import com.wissam.shopifycodingchallenge.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    private final CartFactory cartFactory;

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartProductRepository cartProductRepository;

    @Autowired
    public CartService(CartRepository cartRepository,
                       CartFactory cartFactory,
                       ProductRepository productRepository,
                       CartProductRepository cartProductRepository) {
        this.cartFactory = cartFactory;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartProductRepository = cartProductRepository;
    }

    public String createCart() {
        Cart cart = cartFactory.createCart();
        cartRepository.save(cart);
        return cart.getId();
    }

    public void addProduct(String cartId, String productId, Long quantity) {
        Cart cart = cartRepository.findCartById(cartId);
        if (cart == null) {
            throw new CartNotFoundException(cartId);
        }
        Product product = productRepository.findProductById(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        cart.addProduct(new CartProduct(productId, cartId, quantity));
        cartRepository.save(cart);
    }

    @Transactional
    public void completeCart(String cartId) {
        List<CartProduct> products = cartProductRepository.findCartProductsByCartId(cartId);

        for(CartProduct product : products) {
            String id = product.getProductId();
            Product foundProduct = productRepository.findProductById(id);
            Long updatedInventory = foundProduct.getInventoryCount() - product.getQuantity();
            if (updatedInventory < 0) {
                throw new ProductOutOfStockException(foundProduct.getTitle());
            }
            foundProduct.setInventoryCount(updatedInventory);
            productRepository.save(foundProduct);
            cartProductRepository.deleteCartProductsByCartId(cartId);
        }
    }

}

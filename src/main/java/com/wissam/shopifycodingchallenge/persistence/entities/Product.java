package com.wissam.shopifycodingchallenge.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    public Product(){
        //default constructor to please hibernate
    }

    public Product(String title, Long price, Long inventoryCount) {
        this.title = title;
        this.price = price;
        this.inventoryCount = inventoryCount;
    }

    @Id
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "inventory_count", nullable = false)
    private Long inventoryCount;

    public String getTitle() {
        return title;
    }

    public Long getPrice() {
        return price;
    }

    public Long getInventoryCount() {
        return inventoryCount;
    }
}

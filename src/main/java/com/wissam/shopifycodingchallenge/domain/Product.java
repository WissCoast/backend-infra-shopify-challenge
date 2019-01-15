package com.wissam.shopifycodingchallenge.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private String id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "price", nullable = false)
    private Long price;

    public void setInventoryCount(Long inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    @Column(name = "inventory_count", nullable = false)
    private Long inventoryCount;

    public String getId() {
        return id;
    }

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

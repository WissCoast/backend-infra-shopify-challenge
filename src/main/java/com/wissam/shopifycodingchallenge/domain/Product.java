package com.wissam.shopifycodingchallenge.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Long inventoryCount;

    public Product() {
        //default constructor to please hibernate
    }

    public Product(String title, Long price, Long inventoryCount) {
        this.title = title;
        this.price = price;
        this.inventoryCount = inventoryCount;
    }

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

    public void setInventoryCount(Long inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}

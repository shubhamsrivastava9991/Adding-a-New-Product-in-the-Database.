package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.java
 * This is a model class represents a User entity
 * 
 *
 */

@Entity
@Table(name="products")
public class Product {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_id")
    protected int product_id;
 
    @Column(name="product_name")
    protected String product_name;
 
    @Column(name="product_price")
    protected float product_price;
 
    public Product() {
    }
 
    public Product(String product_name, float product_price) {
        super();
        this.product_name = product_name;
        this.product_price = product_price;
        
    }

    public Product(int product_id, String product_name, float product_price) {
        super();
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public int getId() {
        return product_id;
    }
    public void setId(int id) {
        this.product_id = id;
    }
    public String getName() {
        return product_name;
    }
    public void setName(String name) {
        this.product_name = name;
    }
    public float getPrice() {
        return product_price;
    }
    public void setPrice(float product_price) {
        this.product_price = product_price;
    }
}
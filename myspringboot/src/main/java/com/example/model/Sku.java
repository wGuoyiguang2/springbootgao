package com.example.model;

import java.io.Serializable;

public class Sku implements Serializable {

    private Long id ;

    private float price ;


    //库存
    private Integer stock ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

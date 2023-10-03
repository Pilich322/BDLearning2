package com.example.bdlearning2.data;

import java.io.Serializable;

public class Flower implements Serializable {
    private String type;
    private String color;
    private int price;
    private int marketId;
    private int id;

    public Flower() {
    }

    public Flower(String type, String color, int price, int marketId) {
        this.type = type;
        this.color = color;
        this.price = price;
        this.marketId = marketId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }
}

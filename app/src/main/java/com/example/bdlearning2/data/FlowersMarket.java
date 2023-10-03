package com.example.bdlearning2.data;

import java.io.Serializable;

public class FlowersMarket implements Serializable {
    private int id;
    private String address;
    public FlowersMarket(String address) {
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public FlowersMarket() {
    }
}

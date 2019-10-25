package com.example.hw2infs3634;

public class OrderRecord {

    private String orderpagefoodname;

    private int orderpagequantity;
    private int orderpagetotal;

    public OrderRecord(String orderpagefoodname, int orderpagequantity, int orderpagetotal) {
        this.orderpagefoodname = orderpagefoodname;
        this.orderpagequantity = orderpagequantity;

        this.orderpagetotal = orderpagetotal;
    }

    public String getFoodName() {
        return orderpagefoodname;
    }

    public int getFoodQua1() {
        return orderpagequantity;
    }

    public int getFoodPrice() {
        return orderpagetotal;
    }


}



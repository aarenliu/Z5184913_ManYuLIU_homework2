package com.example.hw2infs3634;

public class MenuData {

    private String foodName;
    private String foodDes;
    private String foodPrice;
    private int foodimage;

    public MenuData(String foodName, String foodDes, String foodPrice, int foodimage) {
        this.foodName = foodName;
        this.foodDes = foodDes;
        this.foodPrice = foodPrice;
        this.foodimage = foodimage;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDes() {
        return foodDes;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public int getFoodimage() {
        return foodimage;
    }
}

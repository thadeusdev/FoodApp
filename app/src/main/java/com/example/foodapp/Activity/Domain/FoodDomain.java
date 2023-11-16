package com.example.foodapp.Activity.Domain;

public class FoodDomain {
    private String title;
    private String pic;
    private String description;
    private Double fee;
    private int numberInCart;

    public FoodDomain(String title, String pic, String description, Double fee) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
    }

    public FoodDomain(String title, String pic, String description, Double fee, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getPic () {
        return pic;
    }

    public void setPic (String pic) {
        this.pic = pic;
    }

    public Double getFee () {
        return fee;
    }

    public void setFee (Double fee) {
        this.fee = fee;
    }
}

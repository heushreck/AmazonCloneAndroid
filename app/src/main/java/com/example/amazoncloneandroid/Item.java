package com.example.amazoncloneandroid;


import java.io.Serializable;

public class Item implements Serializable {
    private String item_title;
    private float item_price;
    private String item_description;
    private int imgId;

    public Item(String item_title, float item_price, String item_description, int imgId){
        this.item_title = item_title;
        this.item_price = item_price;
        this.item_description = item_description;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public float getItem_price() {
        return item_price;
    }

    public String getItem_price_string() {
        return "€" + item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }
}

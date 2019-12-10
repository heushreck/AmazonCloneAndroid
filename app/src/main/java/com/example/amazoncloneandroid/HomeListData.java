package com.example.amazoncloneandroid;

public class HomeListData {
    private String title;
    private String bottom_string;
    private Item[] itemList;

    public HomeListData(String title, String bottom_string, Item[] itemList) {
        this.title = title;
        this.bottom_string = bottom_string;
        this.itemList = itemList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBottom_string() {
        return bottom_string;
    }

    public void setBottom_string(String bottom_string) {
        this.bottom_string = bottom_string;
    }

    public Item[] getItemList() {
        return itemList;
    }

    public void setItemList(Item[] itemList) {
        this.itemList = itemList;
    }
}

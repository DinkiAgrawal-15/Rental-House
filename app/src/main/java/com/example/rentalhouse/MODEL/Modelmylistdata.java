package com.example.rentalhouse.MODEL;

public class Modelmylistdata {
    private String House_name;
    private int house_rating;
    private int house_image;
    public Modelmylistdata(String House_name, int house_rating, int house_image) {
        this.House_name = House_name;
        this.house_rating= house_rating;
        this.house_image= house_image;
    }

    public String getHouse_name() {
        return House_name;
    }

    public void setHouse_name(String house_name) {
        House_name = house_name;
    }

    public int getHouse_rating() {
        return house_rating;
    }

    public void setHouse_rating(int house_rating) {
        this.house_rating = house_rating;
    }

    public int getHouse_image() {
        return house_image;
    }

    public void setHouse_image(int house_image) {
        this.house_image = house_image;
    }

}

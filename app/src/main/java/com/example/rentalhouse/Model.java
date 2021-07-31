package com.example.rentalhouse;

public class Model {

    public String imageurl, House_name;
    public  Model() {
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getHouse_name() {
        return House_name;
    }

    public void setHouse_name(String house_name) {
        House_name = house_name;
    }

    public Model(String imageurl, String house_name) {
        this.imageurl = imageurl;
        House_name = house_name;
    }
}
  /*  public Model(String imageurl, String House_name) {
        this.imageurl = imageurl;
        House_name = House_name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getHouse_name() {
        return House_name;
    }

    public void setHouse_name(String house_name) {
        House_name = House_name;
    }
/* public Model(){

    }

    public String getHouse_name() {
        return House_name;
    }

    public void setHouse_name(String house_name) {
        House_name = house_name;
    }

    public Model(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}*/


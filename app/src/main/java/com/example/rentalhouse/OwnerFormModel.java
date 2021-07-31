package com.example.rentalhouse;

public class OwnerFormModel {
    String whatsapp,phone,address,pincode,city,district,landmark,rent,c1,c2,c3,Family,bach;

    public OwnerFormModel(String whatsapp, String phone,String address, String pincode, String city, String district, String landmark, String rent, String c1, String c2, String c3, String Family, String bach) {
        this.whatsapp = whatsapp;
        this.phone= phone;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.district = district;
        this.landmark = landmark;
        this.rent = rent;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.Family = Family;
        this.bach = bach;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
    public String getphone() {
        return phone;
    }

    public void setphone(String whatsapp) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getBach() {
        return bach;
    }

    public void setBach(String bach) {
        this.bach = bach;
    }


}

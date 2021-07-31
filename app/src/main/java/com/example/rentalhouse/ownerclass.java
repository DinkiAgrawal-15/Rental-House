package com.example.rentalhouse;

public class ownerclass {
    String fname,email,password,cnfrmpassword,phoneno,referal;

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return cnfrmpassword;
    }

    public void setConfirm_password(String confirm_password) {
        this.cnfrmpassword = confirm_password;
    }

    public String getPhone_number() {
        return phoneno;
    }

    public void setPhone_number(String phone_number) {
        this.phoneno = phone_number;
    }

    public String getReferal() {
        return referal;
    }

    public void setReferal(String referal) {
        this.referal = referal;
    }

    public ownerclass(String name, String email, String password, String confirm_password, String phone_number, String referal) {
        this.fname = name;
        this.email = email;
        this.password = password;
        this.cnfrmpassword = confirm_password;
        this.phoneno = phone_number;
        this.referal = referal;
    }
}

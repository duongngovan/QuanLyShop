package com.nguoisomot.shoppingproject;

import android.widget.LinearLayout;

public class AddressModel {
    private String fullname;
    private String address;
    private String pincode;
    private Boolean seleted;

    public AddressModel(String fullname, String address, String pincode, boolean seleted) {
        this.fullname = fullname;
        this.address = address;
        this.pincode = pincode;
        this.seleted = seleted;
    }

    public Boolean getSeleted() {
        return seleted;
    }

    public void setSeleted(Boolean seleted) {
        this.seleted = seleted;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
}

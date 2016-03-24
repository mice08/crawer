package com.mk.crawer.biz.bean;


public class Results {

    private String name;
    private Location location;
    private String address;
    private String telephone;
    private int detail;
    private String uid;



    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getTelephone() {
        return telephone;
    }


    public void setDetail(int detail) {
        this.detail = detail;
    }
    public int getDetail() {
        return detail;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getUid() {
        return uid;
    }

}
package com.mk.crawer.api.dtos;

import java.util.List;

public class HotelInfo {

    private String status;
    private String count;
    private String info;
    private String infocode;
    private List<Pois> pois;


    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }


    public void setCount(String count) {
        this.count = count;
    }
    public String getCount() {
        return count;
    }


    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }


    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }
    public String getInfocode() {
        return infocode;
    }


    public void setPois(List<Pois> pois) {
        this.pois = pois;
    }
    public List<Pois> getPois() {
        return pois;
    }

}

package com.mk.crawer.biz.bean;

import java.util.List;

/**
 * Created by chenqi on 16/3/23.
 */
public class BaiduHotelsearch {

    private int status;
    private String message;
    private int total;
    private List<Results> results;


    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }


    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }


    public void setResults(List<Results> results) {
        this.results = results;
    }
    public List<Results> getResults() {
        return results;
    }
}

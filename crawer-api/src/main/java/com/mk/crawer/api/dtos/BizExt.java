package com.mk.crawer.api.dtos;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.util.StringUtils;

public class BizExt {

    private String rating;

    private String star;

    private String cost;
    @JSONField(name ="hotel_ordering")
    private String hotelOrdering;
    @JSONField(name ="lowest_price")
    private String lowestPrice;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        if (!StringUtils.isEmpty(rating)&&!rating.equals("[]")){
            this.rating = rating;
        }
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        if (!StringUtils.isEmpty(star)&&!star.equals("[]")){
            this.star = star;
        }
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        if (!StringUtils.isEmpty(cost)&&!cost.equals("[]")){
            this.cost = cost;
        }
    }

    public String getHotelOrdering() {
        return hotelOrdering;
    }

    public void setHotelOrdering(String hotelOrdering) {
        if (!StringUtils.isEmpty(hotelOrdering)&&!hotelOrdering.equals("[]")){
            this.hotelOrdering = hotelOrdering;
        }
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        if (!StringUtils.isEmpty(lowestPrice)&&!lowestPrice.equals("[]")){
            this.lowestPrice = lowestPrice;
        }
    }
}

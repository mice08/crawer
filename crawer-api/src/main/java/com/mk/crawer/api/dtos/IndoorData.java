package com.mk.crawer.api.dtos;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.util.StringUtils;

public class IndoorData {
    @JSONField(name ="cpid")
    private String cpId;
    private String floor;
    @JSONField(name ="truefloor")
    private String trueFloor;

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        if (!StringUtils.isEmpty(cpId)&&!cpId.equals("[]")){
            this.cpId = cpId;
        }
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        if (!StringUtils.isEmpty(floor)&&!floor.equals("[]")){
            this.floor = floor;
        }
    }

    public String getTrueFloor() {
        return trueFloor;
    }

    public void setTrueFloor(String trueFloor) {
        if (!StringUtils.isEmpty(trueFloor)&&!trueFloor.equals("[]")){
            this.trueFloor = trueFloor;
        }
    }
}

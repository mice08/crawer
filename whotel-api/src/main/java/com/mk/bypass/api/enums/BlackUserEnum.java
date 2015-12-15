package com.mk.bypass.api.enums;

/**
 * Created by kirinli on 15/9/9.
 */
public enum BlackUserEnum {
    VALID("F",0),
    INVALID("T",1);


    private String name;
    private int value;

    private BlackUserEnum(String name, int value) {
         this.name = name;
         this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

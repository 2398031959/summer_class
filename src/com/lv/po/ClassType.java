package com.lv.po;

public class ClassType {
    private Integer ctId;

    private String ctName;

    private Integer ctPrice;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName == null ? null : ctName.trim();
    }

    public Integer getCtPrice() {
        return ctPrice;
    }

    public void setCtPrice(Integer ctPrice) {
        this.ctPrice = ctPrice;
    }
}
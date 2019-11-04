package com.lv.po;

public class Subject {
    private Integer subId;

    private String subName;

    private Integer subPrice;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public Integer getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(Integer subPrice) {
        this.subPrice = subPrice;
    }

	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName
				+ ", subPrice=" + subPrice + "]";
	}
}
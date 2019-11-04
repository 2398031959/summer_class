package com.lv.util;

import java.util.Arrays;

public class SIdAndSubIds {
	private Integer sId;
	private Integer[] subIds;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public Integer[] getSubIds() {
		return subIds;
	}
	public void setSubIds(Integer[] subIds) {
		this.subIds = subIds;
	}
	@Override
	public String toString() {
		return "SIdAndSubIds [sId=" + sId + ", subIds="
				+ Arrays.toString(subIds) + "]";
	}
}

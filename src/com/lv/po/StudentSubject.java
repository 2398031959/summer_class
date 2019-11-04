package com.lv.po;

public class StudentSubject {
    private Integer ssId;

    private Integer sId;

    private Integer subId;

    public StudentSubject() {
		super();
	}

	public StudentSubject(Integer sId, Integer subId) {
		super();
		this.sId = sId;
		this.subId = subId;
	}

	public Integer getSsId() {
        return ssId;
    }

    public void setSsId(Integer ssId) {
        this.ssId = ssId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }
}
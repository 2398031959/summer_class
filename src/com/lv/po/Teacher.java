package com.lv.po;

import java.util.Date;

public class Teacher {
    private Integer tId;

    private String tName;

    private String tSex;

    private String tPhone;

    private String tSchool;

    private Integer tEducation;

    private String tAddress;

    private Date tDate;
    
    private Education education;
    
	public Teacher(String tName, String tSchool, Integer tEducation) {
		super();
		this.tName = tName;
		this.tSchool = tSchool;
		this.tEducation = tEducation;
	}



	public Teacher() {
		super();
	}



	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", tName=" + tName + ", tSex=" + tSex
				+ ", tPhone=" + tPhone + ", tSchool=" + tSchool
				+ ", tEducation=" + tEducation + ", tAddress=" + tAddress
				+ ", tDate=" + tDate + ", education=" + education + "]";
	}



	public Education getEducation() {
		return education;
	}



	public void setEducation(Education education) {
		this.education = education;
	}



	public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex == null ? null : tSex.trim();
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone == null ? null : tPhone.trim();
    }

    public String gettSchool() {
        return tSchool;
    }

    public void settSchool(String tSchool) {
        this.tSchool = tSchool == null ? null : tSchool.trim();
    }

    public Integer gettEducation() {
        return tEducation;
    }

    public void settEducation(Integer tEducation) {
        this.tEducation = tEducation;
    }

    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress == null ? null : tAddress.trim();
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }
}
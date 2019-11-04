package com.lv.po;

import java.util.Date;
import java.util.List;

public class Student {
    private Integer sId;

    private String sName;

    private String sSex;

    private Integer sClass;

    private Integer sClasstype;

    private String sPhone;

    private String sAddress;

    private Date sDate;

    private Integer sTuition;

    private String sPwd;

    private StudentClass studentClass;
    
    private ClassType classType;
    
    private List<Subject> subjects;
    
    public Student() {
		super();
	}

	public Student(String sName, Integer sClass, Integer sClasstype) {
		super();
		this.sName = sName;
		this.sClass = sClass;
		this.sClasstype = sClasstype;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sSex=" + sSex
				+ ", sClass=" + sClass + ", sClasstype=" + sClasstype
				+ ", sPhone=" + sPhone + ", sAddress=" + sAddress + ", sDate="
				+ sDate + ", sTuition=" + sTuition + ", sPwd=" + sPwd
				+ ", studentClass=" + studentClass + ", classType=" + classType
				+ ", subjects=" + subjects + "]";
	}

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public ClassType getClassType() {
		return classType;
	}

	public void setClassType(ClassType classType) {
		this.classType = classType;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    public Integer getsClass() {
        return sClass;
    }

    public void setsClass(Integer sClass) {
        this.sClass = sClass;
    }

    public Integer getsClasstype() {
        return sClasstype;
    }

    public void setsClasstype(Integer sClasstype) {
        this.sClasstype = sClasstype;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public Integer getsTuition() {
        return sTuition;
    }

    public void setsTuition(Integer sTuition) {
        this.sTuition = sTuition;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd == null ? null : sPwd.trim();
    }
}
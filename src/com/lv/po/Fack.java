package com.lv.po;

public class Fack {
    private Integer fId;

    private String fStart;

    private String fEnd;

    private String fReason;

    private String fStatus;

    private Integer fSid;
    
    private Student student;
    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Fack [fId=" + fId + ", fStart=" + fStart + ", fEnd=" + fEnd
				+ ", fReason=" + fReason + ", fStatus=" + fStatus + ", fSid="
				+ fSid + ", student=" + student + "]";
	}

	public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfStart() {
        return fStart;
    }

    public void setfStart(String fStart) {
        this.fStart = fStart == null ? null : fStart.trim();
    }

    public String getfEnd() {
        return fEnd;
    }

    public void setfEnd(String fEnd) {
        this.fEnd = fEnd == null ? null : fEnd.trim();
    }

    public String getfReason() {
        return fReason;
    }

    public void setfReason(String fReason) {
        this.fReason = fReason == null ? null : fReason.trim();
    }

    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus == null ? null : fStatus.trim();
    }

    public Integer getfSid() {
        return fSid;
    }

    public void setfSid(Integer fSid) {
        this.fSid = fSid;
    }
}
package com.ic.ee.domain.common;

import java.util.Date;

public class AcademicPeriod {

	private Integer academicPeriodId;

	private String name;
	private String shortName;

	private Date startTime;
	private Date endTime;

	public AcademicPeriod() {
		// TODO Auto-generated constructor stub
	}

	public AcademicPeriod(Integer academicPeriodId) {
		this.academicPeriodId = academicPeriodId;
	}

	public Integer getAcademicPeriodId() {
		return academicPeriodId;
	}

	public void setAcademicPeriodId(Integer academicPeriodId) {
		this.academicPeriodId = academicPeriodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}

package com.ic.ee.domain.common;

import java.sql.Timestamp;

public class AcademicPeriod {

	private Integer academicPeriodId;

	private String name;
	private String shortName;

	private Timestamp startTime;
	private Timestamp endTime;

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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}

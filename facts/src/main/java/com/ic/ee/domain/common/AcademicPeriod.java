package com.ic.ee.domain.common;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;

public class AcademicPeriod {

	@JsonView(Views.Public.class)
	private Integer academicPeriodId;

	@JsonView(Views.Public.class)
	private String name;

	@JsonView(Views.Public.class)
	private String shortName;

	@JsonView(Views.Public.class)
	private Timestamp startTime;

	@JsonView(Views.Public.class)
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

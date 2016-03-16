package com.ic.ee.domain.course;

import java.util.Set;

import com.ic.ee.domain.common.AcademicPeriod;
import com.ic.ee.domain.user.courseowner.CourseOwner;

public class CourseDetails {

	private Integer courseId;

	private String name;
	private String shortName;
	private String description;

	private AcademicPeriod academicPeriod;

	private Set<CourseOwner> courseOwners;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AcademicPeriod getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(AcademicPeriod academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public Set<CourseOwner> getCourseOwners() {
		return courseOwners;
	}

	public void setCourseOwners(Set<CourseOwner> courseOwners) {
		this.courseOwners = courseOwners;
	}
}

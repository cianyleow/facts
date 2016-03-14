package com.ic.ee.domain.user.group.constraint;

import java.util.Date;

public class GroupConstraint {

	private Integer groupConstraintId;

	private Integer minimumGroupSize;
	private Integer maximumGroupSize;

	private Date groupFromDate;
	private Date groupByDate;

	public Integer getGroupConstraintId() {
		return groupConstraintId;
	}

	public void setGroupConstraintId(Integer groupConstraintId) {
		this.groupConstraintId = groupConstraintId;
	}

	public Integer getMinimumGroupSize() {
		return minimumGroupSize;
	}

	public void setMinimumGroupSize(Integer minimumGroupSize) {
		this.minimumGroupSize = minimumGroupSize;
	}

	public Integer getMaximumGroupSize() {
		return maximumGroupSize;
	}

	public void setMaximumGroupSize(Integer maximumGroupSize) {
		this.maximumGroupSize = maximumGroupSize;
	}

	public Date getGroupFromDate() {
		return groupFromDate;
	}

	public void setGroupFromDate(Date groupFromDate) {
		this.groupFromDate = groupFromDate;
	}

	public Date getGroupByDate() {
		return groupByDate;
	}

	public void setGroupByDate(Date groupByDate) {
		this.groupByDate = groupByDate;
	}
}
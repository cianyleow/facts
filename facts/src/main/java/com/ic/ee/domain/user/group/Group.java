package com.ic.ee.domain.user.group;

import java.util.Set;

import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.User;

public class Group {

	private Integer groupId;

	private Assignment assignment;

	private Set<User> members;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}
}

package com.ic.ee.domain.user.group;

import java.util.Set;

import com.ic.ee.domain.course.assignment.Assignment;
import com.ic.ee.domain.user.student.Student;

public class Group {

	private Integer groupId;

	private Assignment assignment;

	private Set<Student> members;

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

	public Set<Student> getMembers() {
		return members;
	}

	public void setMembers(Set<Student> members) {
		this.members = members;
	}
}

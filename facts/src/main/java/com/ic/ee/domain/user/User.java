package com.ic.ee.domain.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.ic.ee.domain.Views;

public class User {

	@JsonView(Views.Student.class)
	private String userName;

	@JsonView(Views.Student.class)
	private String firstName;

	@JsonView(Views.Student.class)
	private String lastName;

	@JsonView(Views.Student.class)
	private String email;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

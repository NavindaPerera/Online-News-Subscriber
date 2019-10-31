package com.example.onlinenewssubscriber.controller.dto;

import com.example.onlinenewssubscriber.domain.subscriber.Role;

public class CreateSubscriberDTO {

	private Role role;
	private String firstName;
	private String lastName;
	private int age;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

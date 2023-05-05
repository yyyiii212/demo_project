package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;

public class PersonRes {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Person> person;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String id;

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

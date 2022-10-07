package com.example.demo_project.service.impl;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;

public class PersonServiceImpl implements PersonService {

	@Override
	public Person getPersonInfo(String id) {
		Person person = new Person();
		person.setId(id);
		person.setCity("bb");
		person.setAge(18);
		person.setName("Balangehcimia");
		return person;
	}

//	public String getPersonId(Person person) {
//		return person.getId();
//	}
//
//	public String getPersonCity(Person person) {
//		return person.getCity();
//	}
//
//	public String getPersonName(Person person) {
//		return person.getName();
//	}
//
//	public Integer getPersonAge(Person person) {
//		return person.getAge();
//	}
	public void printPersonAttributes(Person person) {
		System.out.println(person.getAge());
		System.out.println(person.getCity());
		System.out.println(person.getId());
		System.out.println(person.getName());
	}

}

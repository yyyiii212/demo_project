package com.example.demo_project.service.ifs;

import java.util.List;
import java.util.Optional;

import com.example.demo_project.entity.Person;
import com.example.demo_project.vo.PersonRes;

public interface PersonService {
	public List<Person> getPersonInfo();
	
	public Person getPersonInfoById(String id);
	
	public List<Person> getPersonInfoByAgeLargerThan(int age);
	
	public List<Person> getPersonInfoByAgeLargerThan1(String name,int age);

}
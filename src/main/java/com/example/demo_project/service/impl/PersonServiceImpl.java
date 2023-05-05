package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
import com.example.demo_project.repository.PersonDao;
import com.example.demo_project.service.ifs.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

//	@Override
//	public Person getPersonInfo(String id) {
//		Person person = new Person();
//		person.setId(id);
//		person.setAge(18);
//		person.setName("Balangehcimia");
//		return person;
//	}

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
//	public void printPersonAttributes(Person person) {
//		System.out.println(person.getAge());
//		System.out.println(person.getId());
//		System.out.println(person.getName());
//	}
	@Autowired
	private PersonDao personDao;
	
	Person jason = new Person("jason", "120", 81);
	Person john = new Person("john", "123", 45);
	Person jin = new Person("jin", "121", 35);

	@Override
	public List<Person> getPersonInfo() {
		List<Person> person =personDao.findAll();
//		List<Person> person = new ArrayList<>();
//		person.add(jason);
//		person.add(jin);
//		person.add(john);
		return person;
	}

	@Override
	public Person getPersonInfoById(String id) {
//		Person per = personDao.getById(id);
//		return per;
		//List<Person> person = new ArrayList<>();
//		List<Person> id1 = new ArrayList<>();
//		person = getPersonInfo();
//		for (Person item : person) {
//			if (id.equals(item.getId())) {
//				id1.add(item);
//				res.setPerson(id1);
//				return res;
//			}
//		}
		Optional<Person> per = personDao.findById(id);   //單一物件用Optional方法
//		if (per.isPresent()) {      //判斷有沒有值，如果有符合
//			return per.get();       //就會得到
//		}else {
//			return new Person();
//		}
		return per.orElse(new Person()); //判斷有沒有值，回傳內容物

	}

	@Override
	public List<Person> getPersonInfoByAgeLargerThan(int age) {
//		List<Person> person =personDao.findAll();
//		List<Person> age1 = new ArrayList<>();
//		person = getPersonInfo();
//		for (Person item : getPersonInfo()) {
//			if (age < item.getAge()) {
//				age1.add(item);
//			}
//		}
//		return age1;
		List<Person> per = personDao.findByAgeGreaterThanEqual(age);
		return per;
	}
	
	public List<Person> getPersonInfoByAgeLargerThan1(String name, int age) {
		List<Person> per = personDao.findByNameAndAgeGreaterThan(name,age);

		return per;
	}

}

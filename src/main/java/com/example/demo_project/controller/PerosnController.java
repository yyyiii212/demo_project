package com.example.demo_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.vo.OrderReq;
import com.example.demo_project.vo.PersonReq;
import com.example.demo_project.vo.PersonRes;

@RestController
public class PerosnController {
	@Autowired
	private PersonService personservice;

	@PostMapping(value = "/api/getPersonInfo")
	public PersonRes getPersonInfo() {
		PersonRes res = new PersonRes();
		res.setPerson(personservice.getPersonInfo());
		return res;
	}

	@PostMapping(value = "/api/getPersonInfoById")
	public Person getPersonInfoById(@RequestBody PersonReq req) {
//		PersonRes res = new PersonRes();
//		res = personservice.getPersonInfoById(req.getId());
//		return res;
//		Optional<Person> res = Optional.empty();
//		res = personservice.getPersonInfoById(req.getId());
//		return res;
		Person per = personservice.getPersonInfoById(req.getId());
		return per;
	}

	@PostMapping(value = "/api/getPersonInfoByAgeLargerThan")
	public List<Person> getPersonInfoByAgeLargerThan(@RequestBody PersonReq req) {
//		PersonRes res = new PersonRes();
//		res.setPerson(personservice.getPersonInfoByAgeLargerThan(req.getAge()));
		return personservice.getPersonInfoByAgeLargerThan(req.getAge());
	}
	@PostMapping(value = "/api/getPersonInfoByAgeLargerThan1")
	public List<Person> getPersonInfoByAgeLargerThan1(@RequestBody PersonReq req) {

		return personservice.getPersonInfoByAgeLargerThan1(req.getName(),req.getAge());
	}
}

package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.service.ifs.Active;
@Service
public class BirdServiceImpl implements Active{
	@Override
	public void fly(String name,int age) {
		Bird bird = new Bird();
			bird.setAge(18);
			bird.setName("Balangehcimia");
			System.out.println("今年"+age+"歲的"+name+"正在飛");

	}
}

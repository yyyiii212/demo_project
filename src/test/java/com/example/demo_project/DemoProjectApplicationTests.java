package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo_project.service.ifs.Active;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.service.impl.BirdServiceImpl;

@SpringBootTest
class DemoProjectApplicationTests {
//	@Autowired
//	private Active active;
	@Autowired
	private Active active;

	@Test
	public void contextLoads() {
		active.fly("asd", 81);
	}
//	@Test
//		public void activeTest() {
//		active.fly("asd", 81);
//		}
	

}

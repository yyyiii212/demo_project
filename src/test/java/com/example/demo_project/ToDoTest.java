package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.service.ifs.ToDoService;
import com.example.demo_project.vo.ToDoReq;

@SpringBootTest
public class ToDoTest {
@Autowired
private ToDoService toDoService;

@Test
public void setIsCheckedOfToDo() throws Exception{
	ToDoReq req = new ToDoReq();
	req.setName("HIHI");
	toDoService.createToDo(req);
}
}

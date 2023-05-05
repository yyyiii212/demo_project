package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Register;
import com.example.demo_project.vo.RegisterRes;

public interface RegisterService {
	
	public Register register(String account,String pwd,String name,int age,String city);
	
	public RegisterRes activeAccount(String account);
	
	public RegisterRes addRole(String account, List<String> roleList);
	
	public Register findById(String id);
	
	public List<Register> findAll();
}

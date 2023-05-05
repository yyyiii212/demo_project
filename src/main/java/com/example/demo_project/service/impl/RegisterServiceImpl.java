package com.example.demo_project.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.example.demo_project.annotation.ConditionalOnA;
import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.RegisterRes;

@ConditionalOnA
@EnableScheduling
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {
		if (registerDao.existsById(account)) {
			return null;
		}
		Register reg = new Register(account, pwd, name, age, city);
		reg.setRegTime(new Date());// new Date():當前時間
		reg.setRole("Genernal");
//		reg.setActive(false); Active是boolean 預設是false可不用寫
		return registerDao.save(reg);
	}

	@Override
	public RegisterRes activeAccount(String account) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Register reg = regOp.get();
			reg.setActive(true);
			registerDao.save(reg);
			return new RegisterRes(null, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRole(String account, List<String> roleList) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Set<String> roleSet = new HashSet<>();// 不能重複
			// 去除參數裡的重複
			for (String items : roleList) {
				roleSet.add(items);
			}
			// 去除DB中已存在的值和參數的值，兩者重複部分
			Register reg = regOp.get();
			String role = reg.getRole();
			String[] roleArray = role.split(",");// 可能有多個，用(,)區隔，例: Genernal, SA, PM
			for (int i = 0; i < roleArray.length; i++) {
				String item = roleArray[i].trim();// trim去除前後空白
				roleSet.add(item);// 把DB的Role放進Set
			}
			reg.setRole(roleSet.toString());// Set轉String
			reg.setRole(roleSet.toString().substring(1, roleSet.toString().length() - 1));// 取陣列前一個數到後一個數之間的值
//			roleSet.toString().length();//陣列長度
			registerDao.save(reg);
			return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

//	@Scheduled(fixedRateString = "${heart.ms}")
//	public void schedulePrintDate() {
//		System.out.println(new Date());
//	}

	@Override
	public Register findById(String id) {
		Optional<Register> op = registerDao.findById(id);
//		if(op.isPresent()) {
//			return op.get();
//		}
//		return null;
		return op.orElse(null);
	}

	@Override
	public List<Register> findAll() {
		int a = 5/0;
		return registerDao.findAll();
	}
}

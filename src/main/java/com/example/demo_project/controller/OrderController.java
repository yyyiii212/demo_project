package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.MenuRes;
import com.example.demo_project.vo.OrderReq;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderservice;

	@PostMapping(value = "/api/getfood")
	public MenuRes getfood() {
		MenuRes res = new MenuRes();
		res.setMessage("品項資訊");
		res.setMenumap(orderservice.getfood());
		return res;
	}

//	@PostMapping(value = "/api/orders")
//	public MenuRes orders(@RequestBody OrderReq req) {
//		MenuRes res = orderservice.orders(req.getMenumap());
//		return res;
//	}
	
//	@PostMapping(value = "/api/getmenu")
//	public MenuRes getmenu() {
//		MenuRes res = new MenuRes();
//		res.setmenu(orderservice.getmenu());
//		return res;
//	}
}

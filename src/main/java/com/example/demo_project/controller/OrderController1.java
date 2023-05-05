package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService1;
import com.example.demo_project.vo.MenuRes;
import com.example.demo_project.vo.OrderReq;

@RestController
public class OrderController1 {
	@Autowired
	private OrderService1 orderService1;

	@PostMapping(value = "/api/increaseMenu")
	public Menu increaseMenu(@RequestBody OrderReq req) {
		return orderService1.increaseMenu(req.getName(), req.getPrice());
	}

	@PostMapping(value = "/api/getMenu")
	public List<Menu> getMenu() {
		return orderService1.getMenu();
	}

	@PostMapping(value = "/api/getprice")
	public Menu getPrice(@RequestBody OrderReq req) {
		return orderService1.getPrice(req.getName());
	}

	@PostMapping(value = "/api/orders")
	public MenuRes orders(@RequestBody OrderReq req) {
		return orderService1.orders(req.getOrder());
	}

}

package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.repository.OrderDao;
import com.example.demo_project.service.ifs.OrderService1;
import com.example.demo_project.vo.MenuRes;
import com.example.demo_project.vo.OrderReq;

@Service
public class OrderServiceImpl1 implements OrderService1 {
	@Autowired
	private OrderDao orderDao;

	@Override
	public Menu increaseMenu(String name, Integer price) {
		Menu menu = new Menu();
		menu.setName(name);
		menu.setPrice(price);
		orderDao.save(menu);
		return menu;
	}

	@Override
	public List<Menu> getMenu() {
		return orderDao.findAll();
	}

	@Override
	public Menu getPrice(String name) {
//		MenuRes res = new MenuRes();
//		if(!StringUtils.hasText(name)) {
//			res.setMessage("error");
//			return res;
//		}
//		if(!orderDao.findById(name).isPresent()) {
//			res.setMessage(name);
//			res.setMessage("We don't have this food ");
//			return res;
//		}
		Menu menu = orderDao.findById(name).get();
		return menu;
	}

	@Override
	public MenuRes orders(List<OrderReq> menuList) {
		int total = 0;
		List<String> message = new ArrayList<>();
		MenuRes res = new MenuRes();
		for (OrderReq req : menuList) {
			if (!StringUtils.hasText(req.getName())) {
				continue;
			}
			if (orderDao.findById(req.getName()).isPresent()) {
				if (req.getAmount() < 0) {
					req.setAmount(0);
				}
				Menu menu = orderDao.findById(req.getName()).get();
				total += menu.getPrice() * req.getAmount();
				message.add("品項 : " + menu.getName() + ", 價格 : " + menu.getPrice() + ", 數量 : " + req.getAmount());
			}
		}
		if (total > 500) {
			total = (int) (total * 0.9);
		}
		res.setTotal(total);
		res.setMenuList(message);
		return res;
	}

}

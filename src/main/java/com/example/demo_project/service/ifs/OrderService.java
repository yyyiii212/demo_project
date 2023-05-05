package com.example.demo_project.service.ifs;

import java.util.Map;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.vo.MenuRes;

public interface OrderService {
	public void getprice(Menu menu);

	public int totalprice(Map<Menu, Integer> itemMap);

	public void food(Menu menu);

	public Map<String, Integer> getfood();

	public MenuRes orders(Map<String, Integer> menumap);
}

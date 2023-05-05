package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.vo.MenuRes;
import com.example.demo_project.vo.OrderReq;

public interface OrderService1 {
	public Menu increaseMenu(String name,Integer price);
	
	public List<Menu> getMenu();
	
	public Menu getPrice(String name);
	
	public MenuRes orders(List<OrderReq>menumenuList);

}

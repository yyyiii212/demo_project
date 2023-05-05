package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.MenuRes;

@Service
public class OrderServiceImpl implements OrderService {
	private Map<String, Integer> menuMap = new HashMap<>();
//	int[] numlist = new int[3];
//	int k = 0;
//	String[] name = { "beef", "pork", "chicken" };
//	int[] price = { 100, 90, 80 };

	@Override
	public void getprice(Menu menu) {
		menuMap.put(menu.getName(), menu.getPrice());
		System.out.println("繺翴: " + menu.getName() + " ,基: " + menu.getPrice());
	}

//		if (name.equals("beef")) {
//			System.out.println(name + "基: " + price[0] + "じ");
//		}
//		if (name.equals("pork")) {
//			System.out.println(name + "基: " + price[1] + "じ");
//		}
//		if (name.equals("chicken")) {
//			System.out.println(name + "基: " + price[2] + "じ");
//		}
//	}

	public int totalprice(Map<Menu, Integer> itemMap) {
		int totalprice = 0;
		for (Entry<Menu, Integer> item : itemMap.entrySet()) {
			Menu menu = item.getKey();
			int itemPrice = menu.getPrice();
			int num = item.getValue();
			totalprice += itemPrice * num;
		}
		if (totalprice >= 500) {
			totalprice = (int) (totalprice * 0.9);
		}
		System.out.println("羆基: " + totalprice);
		return totalprice;
//		Menu menu = new Menu();
//		Scanner scan = new Scanner(System.in);
//		for (int a = 0; a < 3; a++) {
//			System.out.println("叫翴繺: 1: " + name[0] + "\t 2: " + name[1] + "\t3: " + name[2]);
//			Integer p = scan.nextInt();
//			if (p == 1) {
//				System.out.println(name[p - 1] + "基: " + 100 + "じ");
//				menu.setPrice(100);
//			}
//			if (p == 2) {
//				System.out.println(name[p - 1] + "基: " + 90 + "じ");
//				menu.setPrice(90);
//			}
//			if (p == 3) {
//				System.out.println(name[p - 1] + "基: " + 80 + "じ");
//				menu.setPrice(80);
//			}
//			System.out.println("块碭繺翴: ");
//			int t = scan.nextInt();
//			numlist[k] = t;
//			k++;
//			System.out.println(t + "" + name[p - 1] + "基窥" + t * menu.getPrice() + "じ");
//		}
	}

	@Override
	public void food(Menu menu) {
//		int y = 0;
//		for (int x = 0; x < 3; x++) {
//			y = numlist[x] * price[x] + numlist[x] * price[x] + numlist[x] * price[x];
//		}
//		if (y > 500) {
//			System.out.println("羆肂: " + y * 0.9);
//		}
	}

	private Map<String, Integer> menumap = new HashMap<>();
	Menu beef = new Menu("beef", 100);
	Menu pork = new Menu("pork", 80);
	Menu fish = new Menu("fish", 60);

	@Override
	public Map<String, Integer> getfood() {
		menumap.put(beef.getName(), beef.getPrice());
		menumap.put(pork.getName(), pork.getPrice());
		menumap.put(fish.getName(), fish.getPrice());
		return menumap;
	}

	@Override
	public MenuRes orders(Map<String, Integer> foodmap) {
		MenuRes res = new MenuRes();
		menumap = getfood();
		res.setMenumap(foodmap);
		int totalprice = 0;
		for (Map.Entry<String, Integer> food : foodmap.entrySet()) {
			if (!StringUtils.hasText(food.getKey())) {
				res.setMessage("error");
				return res;
			}
			if (food.getValue()<0) {
				res.setMessage("error");
				return res;
			}
			for (Map.Entry<String, Integer> item : menumap.entrySet()) {
				if(item.getKey().equalsIgnoreCase(food.getKey())) {
				totalprice += food.getValue() * item.getValue();
				}
			}
		}
		if(totalprice>500) {
			totalprice = (int) (totalprice*0.9);
		}
		res.setTotal(totalprice);
		return res;
	}
//	public List<Menu> getmenu() {
//		Menu beef = new Menu("beef", 100);
//		Menu pork = new Menu("pork", 80);
//		Menu fish = new Menu("fish", 60);
//		List<Menu> menulist = new ArrayList<>();
//		menulist.add(beef);
//		menulist.add(fish);
//		menulist.add(pork);
//		return menulist;
//	}

}

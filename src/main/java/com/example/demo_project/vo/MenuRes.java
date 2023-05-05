package com.example.demo_project.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MenuRes {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, Integer> menumap = new HashMap<>();
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> menuList = new ArrayList<>();
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String  message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int total;
//	private List<Menu> menulist;

	public MenuRes() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Integer> getMenumap() {
		return menumap;
	}

	public void setMenumap(Map<String, Integer> menumap) {
		this.menumap = menumap;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<String> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<String> menuList) {
		this.menuList = menuList;
	}
	
//	public MenuRes(List<Menu> menulist) {
//		this.menulist = menulist;
//	}
//
//	public List<Menu> getmenu() {
//		return menulist;
//	}
//
//	public void setmenu(List<Menu> menulist) {
//		this.menulist = menulist;
//	}

}

package com.example.demo_project.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderReq {
//	@JsonProperty("menumap")
//	private Map<String,Integer>menumap = new HashMap<>();
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private Integer price;
	
	@JsonProperty("amount")
	private Integer amount;
	
	private List<OrderReq> order = new ArrayList<>();
	private String message;

	public OrderReq() {

	}
	
//	public Map<String, Integer> getMenumap() {
//		return menumap;
//	}
//
//	public void setMenumap(Map<String, Integer> menumap) {
//		this.menumap = menumap;
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public List<OrderReq> getOrder() {
		return order;
	}

	public void setOrder(List<OrderReq> order) {
		this.order = order;
	}
	
	
}

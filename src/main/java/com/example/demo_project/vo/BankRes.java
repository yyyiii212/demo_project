package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BankRes {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String account;//Bank(已有account && amount) 可以取代上面兩個參數
	private Integer amount;
	private String message;
	public BankRes() {

	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	

}

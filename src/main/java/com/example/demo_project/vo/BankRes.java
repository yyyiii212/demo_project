package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BankRes {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String account;//Bank(�w��account && amount) �i�H���N�W����ӰѼ�
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

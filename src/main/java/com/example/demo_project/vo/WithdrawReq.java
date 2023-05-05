package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawReq {
	@JsonProperty("account")

	private String account;

	@JsonProperty("amount")

	private int amount;
	
	private String message;

	public WithdrawReq() {
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

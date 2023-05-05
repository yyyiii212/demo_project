package com.example.demo_project.vo;

import com.example.demo_project.entity.Register;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterRes {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("register_info")
	private Register register;
	
	private String message;
	
	@JsonProperty("verify_code")
	private int verifyCode;
	
	public RegisterRes() {
		
	}
	
	public RegisterRes(Register register,String message) {
		this.message = message;
		this.register = register;
	}
	
	public RegisterRes(Register register,String message, int verifyCode) {
		this.message = message;
		this.register = register;
		this.verifyCode = verifyCode;
	}

    public RegisterRes(String message) {
		this.message = message;
	}
	
	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}

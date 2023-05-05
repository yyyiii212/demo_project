package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService1;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;

@RestController
public class BankController1 {
	@Autowired
	private BankService1 bankService1;

	@PostMapping(value = "/api/createAccount")
	public Bank createAccount() {
		return bankService1.createAccount();
	}

	@PostMapping(value = "/api/getAmount")
	public BankRes getAmount(@RequestBody BankReq req) {
		BankRes res = new BankRes();
		Bank bank = bankService1.getAmount(req.getAccount());
		if (bank == null) {
			res.setAccount(null);
			res.setAmount(0);
			res.setMessage("error");
		} else {
			res.setAccount(bank.getAccount());
			res.setAmount(bank.getAmount());
			res.setMessage("success");
		}
		return res;
	}

	@PostMapping(value = "/api/deposit")
	public BankRes deposit(@RequestBody BankReq req) {
		BankRes res = new BankRes();
		Bank bank = bankService1.deposit(req.getAccount(), req.getAmount());
		if (bank == null) {
			res.setAccount(null);
			res.setAmount(0);
			res.setMessage("error");
		}
		if (req.getAmount() < 1) {
			res.setAccount(null);
			res.setAmount(0);
			res.setMessage("存入金額不能小於0");
		} else {
			res.setAccount(bank.getAccount());
			res.setAmount(bank.getAmount());
			res.setMessage("success");
		}
		return res;
	}

	@PostMapping(value = "/api/withdraw")
	public BankRes withdraw(@RequestBody BankReq req) {
		BankRes res = new BankRes();
		Bank bank = bankService1.withdraw(req.getAccount(), req.getAmount());
		if (bank == null) {
			res.setAccount(null);
			res.setAmount(0);
			res.setMessage("error");
		}
		if (req.getAmount() < 1 || bank.getAmount()< 0) {
			res.setAccount(null);
			res.setAmount(0);
			res.setMessage("取款不能小於0或是大於存款金額");
		} else {
			res.setAccount(bank.getAccount());
			res.setAmount(bank.getAmount());
			res.setMessage("success");
		}
		return res;
	}

}

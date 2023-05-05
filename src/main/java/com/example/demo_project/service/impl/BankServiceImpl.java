package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;

@Service
public class BankServiceImpl implements BankService {
	@Override
	public Bank getAmount(Bank bank) {
		System.out.println("帳號 : " + bank.getAccount() + "  餘額 : " + bank.getAmount());
		return bank;
	}

	@Override
	public Bank deposit(Bank bank, int depositAmount) {
		bank.setAmount(bank.getAmount() + depositAmount);
		System.out.println("存款成功 : ");
		System.out.println("帳號 : " + bank.getAccount() + "  餘額 : " + bank.getAmount());
		return bank;
	}

	@Override
	public Bank withdraw(Bank bank, int withdrawAmount) {
		bank.setAmount(bank.getAmount() - withdrawAmount);
		if (bank.getAmount() < 0) {
			System.out.println("帳號 : " + bank.getAccount() + " 餘額不足");
		} else {
			System.out.println("取款成功 : ");
			System.out.println("帳號 : " + bank.getAccount() + "  餘額 : " + bank.getAmount());
		}
		return bank;
	}

	@Override
	public Bank deposit(String account, int depositAmount) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(depositAmount+bank.getAmount());
		return bank;
	}
	@Override
	public Bank getAmount(String account) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(1000);
		return bank;
	}

	@Override
	public Bank withdraw(String account, int withdrawAmount) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(bank.getAmount()-withdrawAmount);
		return bank;
	}

}

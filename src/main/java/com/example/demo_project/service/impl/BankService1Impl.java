package com.example.demo_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.repository.BankDao;
import com.example.demo_project.service.ifs.BankService1;

@Service
public class BankService1Impl implements BankService1 {
	@Autowired
	private BankDao bankDao;

	@Override
	public Bank createAccount() {
		Bank bank = new Bank();
		bank.setAccount("A123");
		bank.setAmount(0);
		return bankDao.save(bank);
	}

	@Override
	public Bank getAmount(String account) {
		return bankDao.findByAccount(account);
	}

	@Override
	public Bank deposit(String account, int depositAmount) {
		Bank bank = bankDao.findByAccount(account);
		bank.setAmount(bank.getAmount() + depositAmount);
		Bank newbank = bankDao.save(bank);
		return newbank;
	}

	@Override
	public Bank withdraw(String account, int withdrawAmount) {
		Bank bank = bankDao.findByAccount(account);
		if ((bank.getAmount() < withdrawAmount) ) {
			return bank;
		}else {
			bank.setAmount(bank.getAmount() - withdrawAmount);
			if(bank.getAmount() < 0) {
				return null;
			}
		}
		Bank newbank = bankDao.save(bank);
		return newbank;
	}

}

package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;

@Service
public class BankServiceImpl implements BankService {
	@Override
	public Bank getAmount(Bank bank) {
		System.out.println("�b�� : " + bank.getAccount() + "  �l�B : " + bank.getAmount());
		return bank;
	}

	@Override
	public Bank deposit(Bank bank, int depositAmount) {
		bank.setAmount(bank.getAmount() + depositAmount);
		System.out.println("�s�ڦ��\ : ");
		System.out.println("�b�� : " + bank.getAccount() + "  �l�B : " + bank.getAmount());
		return bank;
	}

	@Override
	public Bank withdraw(Bank bank, int withdrawAmount) {
		bank.setAmount(bank.getAmount() - withdrawAmount);
		if (bank.getAmount() < 0) {
			System.out.println("�b�� : " + bank.getAccount() + " �l�B����");
		} else {
			System.out.println("���ڦ��\ : ");
			System.out.println("�b�� : " + bank.getAccount() + "  �l�B : " + bank.getAmount());
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

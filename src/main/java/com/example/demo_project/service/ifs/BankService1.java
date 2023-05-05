package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;
public interface BankService1 {
	public Bank createAccount();
	
	public Bank getAmount(String account);
	
	public Bank deposit(String account, int depositAmount);
	
	public Bank withdraw(String account, int withdrawAmount);

}

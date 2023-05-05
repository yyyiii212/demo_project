package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;

public interface BankService {
	public Bank getAmount(String account);

	public Bank getAmount(Bank bank);

	public Bank deposit(Bank bank, int depositAmount);

	public Bank withdraw(Bank bank, int withdrawAmount);
	
	public Bank deposit(String account,int depositAmount);
	
	public Bank withdraw(String account, int withdrawAmount);

}

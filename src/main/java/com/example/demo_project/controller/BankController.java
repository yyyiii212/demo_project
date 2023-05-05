//package com.example.demo_project.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo_project.entity.Bank;
//import com.example.demo_project.service.ifs.BankService;
//import com.example.demo_project.vo.BankReq;
//import com.example.demo_project.vo.BankRes;
//import com.example.demo_project.vo.DepositReq;
//import com.example.demo_project.vo.WithdrawReq;
//
//@RestController
//public class BankController {
//	@Autowired
//	private BankService bankservice;
//
//	@PostMapping(value = "/api/getAmount")
//
//	public BankRes getAmount(@RequestBody BankReq request) {
//		BankRes res = new BankRes();
//		if (!StringUtils.hasText(request.getAccount())) {// StringUtils.hasText 是否有字串
//			res.setMessage("error");
//			return res;
//		}
//		Bank bank = bankservice.getAmount(request.getAccount());
//		res.setBank(bank);
//		res.setMessage("Success");
//		return res;
//	}
//	
//	@PostMapping(value = "/api/deposit")
//	public BankRes deposit(@RequestBody DepositReq req) {
//		BankRes res = new BankRes();
//		if (!StringUtils.hasText(req.getAccount())) {
//			res.setMessage("error");
//			return res;
//		}
//		if (req.getAmount() < 0) {
//			res.setMessage("error");
//			return res;
//		}
//		Bank bank = bankservice.deposit(req.getAccount(),req.getAmount());
//		res.setBank(bank);
//		res.setMessage("存錢成功");
//		return res;
//	}
//	
//	@PostMapping(value = "/api/withdraw")
//	public BankRes withdraw(@RequestBody WithdrawReq req) {
//		BankRes res = new BankRes();
//		if (!StringUtils.hasText(req.getAccount())) {
//			res.setMessage("error");
//			return res;
//		}
//		if (req.getAmount() == 0 ) {
//			res.setMessage("error");
//			return res;
//		}
//		Bank b = new Bank();
//		if (b.getAmount()-req.getAmount()<0) {
//			res.setMessage("error");
//			return res;
//		}
//		Bank bank = bankservice.withdraw(req.getAccount(),req.getAmount());
//		res.setBank(bank);
//		res.setMessage("取款成功");
//		return res;
//	}
//}

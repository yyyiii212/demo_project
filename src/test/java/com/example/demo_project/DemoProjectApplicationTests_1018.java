//package com.example.demo_project;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.demo_project.controller.BankController;
//import com.example.demo_project.entity.Bank;
//import com.example.demo_project.service.ifs.BankService;
//import com.example.demo_project.vo.BankReq;
//import com.example.demo_project.vo.BankRes;
//import com.example.demo_project.vo.DepositReq;
//import com.example.demo_project.vo.WithdrawReq;
//
//@SpringBootTest
//public class DemoProjectApplicationTests_1018 {
//	@Autowired
//	private BankService bankservice;
//	@Autowired
//	private BankController bankcontroller;
//
//	@Test
//	public void contextLoads() {
//		BankReq req = new BankReq();
//		req.setAccount("");
//		BankRes res = bankcontroller.getAmount(req);
////		System.out.println(res.getAccount());
////		System.out.println(res.getAmount());
//		System.out.println(res.getBank().getAccount());
//		System.out.println(res.getBank().getAmount());
//		System.out.println(res.getMessage());
//	}
//
//	@Test
//	public void contextLoads1() {
//		DepositReq deposit = new DepositReq();
//		deposit.setAccount("132458");
//		deposit.setAmount(2000);
//		BankRes res = bankcontroller.deposit(deposit);
//		System.out.println(res.getBank().getAccount());
//		System.out.println(res.getBank().getAmount());
//		System.out.println(res.getMessage());
//	}
//	@Test
//	public void contextLoads2() {
//		WithdrawReq withdraw = new WithdrawReq();
//		withdraw.setAccount("132458");
//		withdraw.setAmount(2000);
//		BankRes res = bankcontroller.withdraw(withdraw);
//		System.out.println(res.getBank().getAccount());
//		System.out.println(res.getBank().getAmount());
//		System.out.println(res.getMessage());
//	}
//}

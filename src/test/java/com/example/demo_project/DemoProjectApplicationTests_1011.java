package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;

@SpringBootTest
public class DemoProjectApplicationTests_1011 {
	@Autowired
	private BankService bankservice;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	 public boolean isPalindrome(int x) {
        boolean result = false;
        int temp = x;
        int after = 0;
        if( x < 0 ){
            return result;
            }
        while( temp != 0 ){
            after = after * 10 + temp % 10;
            temp = temp / 10;
        }
        if(x == after){result = true;}
        return result;
    }
}

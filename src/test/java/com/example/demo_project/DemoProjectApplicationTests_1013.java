package com.example.demo_project;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.service.impl.Computer;

@SpringBootTest
public class DemoProjectApplicationTests_1013 {
	@Test
	public void contextLoads() {
		Computer com = new Computer();
		Scanner scan = new Scanner(System.in);
		String operation;
		String YN;
		String pattern = "\\d+";
		String a = null;
		String b = null;
		int x;
		int y;
		back1: for (int i = 4; i > 0;) {
			System.out.println("輸入 Add , Minus , Multi , Division , Mod ");
			operation = scan.next();
			if (!operation.equalsIgnoreCase("Add") && !operation.equalsIgnoreCase("Minus")
					&& !operation.equalsIgnoreCase("Multi") && !operation.equalsIgnoreCase("Division")
					&& !operation.equalsIgnoreCase("Mod")) {
				i--;
				System.out.println("輸入錯誤,重新輸入， 剩 " + i + " 次");
				continue;
			}
			for (int j = 4; j > 0;) {
				System.out.println("輸入數字2-20 : ");
				a = scan.next();
				if (!a.matches(pattern)) {
					i--;
					System.out.println("輸入錯誤,重新輸入 ， 剩 " + i + " 次");
					continue;
				}
				x = Integer.parseInt(a);
				if (2 > x || x > 20) {
					i--;
					System.out.println("輸入錯誤,重新輸入， 剩 " + i + " 次");
					continue;
				}
				for (int k = 4; k > 0;) {
					System.out.println("輸入數字2-20 : ");
					b = scan.next();
					if (!b.matches(pattern)) {
						i--;
						System.out.println("輸入錯誤,重新輸入 ， 剩 " + i + " 次");
						continue;
					}
					y = Integer.parseInt(b);
					if (2 > y || y > 20) {
						i--;
						System.out.println("輸入錯誤,重新輸入 剩 " + i + " 次");
						continue;
					}
					System.out.println("算式為 : " + operation + " " + x + " " + y);
					System.out.println("正確輸入'Y'，錯誤輸入'N'");
					YN = scan.next();
					if (YN.equalsIgnoreCase("Y")) {
						if (operation.equalsIgnoreCase("Add")) {
							com.add(x, y);
							continue back1;
						} else if (operation.equalsIgnoreCase("Minus")) {
							com.Minus(x, y);
							continue back1;
						} else if (operation.equalsIgnoreCase("Multi")) {
							com.Mulit(x, y);
							continue back1;
						} else if (operation.equalsIgnoreCase("Division")) {
							com.Division(x, y);
							continue back1;
						} else if (operation.equalsIgnoreCase("Mod")) {
							com.Mod(x, y);
							continue back1;
						}
					} else if (YN.equalsIgnoreCase("N")) {
						System.out.println("停止程式 : ");
						return;
					} else {
						System.out.println("輸入不正確 : ");
						return;
					}
				}
			}
		}
	}
}

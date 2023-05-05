package com.example.demo_project.service.impl;

public class Computer {

	public void add(int x, int y) {
		int z = x + y;
		System.out.println(x + " + " + y + " = " + z);
		return;
	}

	public void Minus(int x, int y) {
		int z = x - y;
		System.out.println(x + " - " + y + " = " + z);
		return;
	}

	public void Mulit(int x, int y) {
		int z = x * y;
		System.out.println(x + " * " + y + " = " + z);
		return;
	}

	public void Division(int x, int y) {
		double z = (double) x / y;
		System.out.println(x + " / " + y + " = " + z);
		return;
	}

	public void Mod(int x, int y) {
		int z = x % y;
		System.out.println(x + " % " + y + " = " + z);
		return;
	}
}

package com.example.demo_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@SpringBootTest
public class DemoProjectApplicationTests_1012 {
	@Autowired
	private ShoppingService shoppingservice;

	@Test
	public void contextLoads() {
		Product product0 = new Product("water", 20, 10);
		Product product1 = new Product("rice", 50, 10);
		Product product2 = new Product("apple", 30, 10);
		List<String> nameList = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		productList.add(product0);
		productList.add(product1);
		productList.add(product2);
		nameList.add("Water");
		nameList.add("banana");
		shoppingservice.queryProducts(nameList, productList);
//		product0.setQuantity(6);
//		product1.setQuantity(5);
//		product2.setQuantity(7);
		List<Product> buyList = new ArrayList<>();
		Product buy1 = new Product("water",11);
		Product buy2 = new Product("rice",5);
		Product buy3 = new Product("apple",5);
		buyList.add(buy1);
		buyList.add(buy2);
		buyList.add(buy3);
		shoppingservice.checkout(buyList,productList);

	}

}

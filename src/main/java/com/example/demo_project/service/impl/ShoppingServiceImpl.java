package com.example.demo_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Override
	public void queryProducts(List<String> nameList, List<Product> productList) {
		if (nameList.isEmpty()) {
			System.out.println("查尋品項不得為空");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		Map<String,Product> queryMap = new HashMap<>();//Map比對產品方法
		for (String name : nameList) {
			for (Product product : productList) {
				if (name.equalsIgnoreCase(product.getName())) {// equalsIgnoreCase 字串比對不論大小寫
//					queryMap.put(name, product);
					System.out.println("品項 : " + product.getName() + " 價格(元) : " + product.getPrice() + " 庫存 : "
							+ product.getStorage());
					break;
				}
				if (productList.indexOf(product) == productList.size() - 1) {// 陣列跑完印出結果
					System.out.println("無查詢結果");
				}
//				else {
//					queryMap.put(name, null);
//				}
			}
		}
//		for(Entry<String ,Product>mapItem:queryMap.entrySet()) {
//			if(mapItem.getValue()==null) {
//				System.out.println(mapItem.getKey()+"查無結果");
//			}else {
//				Product product = mapItem.getValue();
//				System.out.println("品項: "+product.getName()+"價格: "+product.getPrice()+"庫存: "+product.getStorage());
//			}
//		}

	}

	@Override
	public void checkout(List<Product> buyList,List<Product> productList) {
//		int money = 0;
//		System.out.println("購買清單 : ");
//		for (Product product : productList) {
//			int num = product.getPrice() * product.getQuantity();
//			money += product.getPrice() * product.getQuantity();
//			product.setStorage(product.getStorage() - product.getQuantity());
//			System.out.println("品項 : " + product.getName() + " 價格(元) : " + product.getPrice() + " 購買數量 : "
//					+ product.getQuantity() + " 總金額 : " + num + " 庫存: " + product.getStorage());
//		}
//		System.out.println("總金額 : " + money);
		//多設一個陣列 :
		int total = 0;
		for(Product buy:buyList) {
			for(Product product:productList) {
				if (buy.getName().equalsIgnoreCase(product.getName())) {
					System.out.println("品項: "+product.getName()+" 價格 : "+product.getPrice()+" 購買數量 : "+buy.getQuantity());
					if(product.getStorage() - buy.getQuantity()<0) {
						System.out.println("庫存不足，無法購買");
						break;
					}
					System.out.println("購買總價"+product.getPrice()+buy.getQuantity());
					total += product.getPrice()*buy.getQuantity();
					product.setStorage(product.getStorage()-buy.getQuantity());
					System.out.println("購買後剩餘庫存 : "+product.getStorage());
					System.out.println();
					break;
				}else if (productList.indexOf(product) == productList.size() - 1) {
					System.out.println("查無品項"+buy.getName());
				}
			}
		}
		System.out.println("總價 : "+total);
	}
}

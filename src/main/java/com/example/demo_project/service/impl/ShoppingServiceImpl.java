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
			System.out.println("�d�M�~�����o����");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		Map<String,Product> queryMap = new HashMap<>();//Map��ﲣ�~��k
		for (String name : nameList) {
			for (Product product : productList) {
				if (name.equalsIgnoreCase(product.getName())) {// equalsIgnoreCase �r���藍�פj�p�g
//					queryMap.put(name, product);
					System.out.println("�~�� : " + product.getName() + " ����(��) : " + product.getPrice() + " �w�s : "
							+ product.getStorage());
					break;
				}
				if (productList.indexOf(product) == productList.size() - 1) {// �}�C�]���L�X���G
					System.out.println("�L�d�ߵ��G");
				}
//				else {
//					queryMap.put(name, null);
//				}
			}
		}
//		for(Entry<String ,Product>mapItem:queryMap.entrySet()) {
//			if(mapItem.getValue()==null) {
//				System.out.println(mapItem.getKey()+"�d�L���G");
//			}else {
//				Product product = mapItem.getValue();
//				System.out.println("�~��: "+product.getName()+"����: "+product.getPrice()+"�w�s: "+product.getStorage());
//			}
//		}

	}

	@Override
	public void checkout(List<Product> buyList,List<Product> productList) {
//		int money = 0;
//		System.out.println("�ʶR�M�� : ");
//		for (Product product : productList) {
//			int num = product.getPrice() * product.getQuantity();
//			money += product.getPrice() * product.getQuantity();
//			product.setStorage(product.getStorage() - product.getQuantity());
//			System.out.println("�~�� : " + product.getName() + " ����(��) : " + product.getPrice() + " �ʶR�ƶq : "
//					+ product.getQuantity() + " �`���B : " + num + " �w�s: " + product.getStorage());
//		}
//		System.out.println("�`���B : " + money);
		//�h�]�@�Ӱ}�C :
		int total = 0;
		for(Product buy:buyList) {
			for(Product product:productList) {
				if (buy.getName().equalsIgnoreCase(product.getName())) {
					System.out.println("�~��: "+product.getName()+" ���� : "+product.getPrice()+" �ʶR�ƶq : "+buy.getQuantity());
					if(product.getStorage() - buy.getQuantity()<0) {
						System.out.println("�w�s�����A�L�k�ʶR");
						break;
					}
					System.out.println("�ʶR�`��"+product.getPrice()+buy.getQuantity());
					total += product.getPrice()*buy.getQuantity();
					product.setStorage(product.getStorage()-buy.getQuantity());
					System.out.println("�ʶR��Ѿl�w�s : "+product.getStorage());
					System.out.println();
					break;
				}else if (productList.indexOf(product) == productList.size() - 1) {
					System.out.println("�d�L�~��"+buy.getName());
				}
			}
		}
		System.out.println("�`�� : "+total);
	}
}

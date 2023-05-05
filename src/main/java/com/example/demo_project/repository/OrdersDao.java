package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Orders;
import com.example.demo_project.vo.OrdersInfo;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {

	@Query(" select new com.example.demo_project.vo.OrdersInfo( c.name, o.productName, o.quantity, o.customersId ) "
			+ " from Orders o join Customers c" + " on c.id = o.customersId ")
	public List<OrdersInfo> findAllOrdersInfo();

//	@Query(" select new com.example.demo_project.vo.OrdersInfo(c.name, o.productName, o.quantity, o.customersId ) "
//			+ " from Customers c join Orders o " + " on c.id = o.customers_id ")
//	public List<OrdersInfo> findOrdersInfoByCustomersIdIn(@Param("customersId") int id);

}

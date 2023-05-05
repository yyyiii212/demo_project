package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank,String>{
	public Bank findByAccount(String account);
}

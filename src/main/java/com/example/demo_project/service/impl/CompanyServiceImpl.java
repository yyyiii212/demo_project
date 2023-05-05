package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.OrgCompanyId;
import com.example.demo_project.repository.CompanyDao;
import com.example.demo_project.service.ifs.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> findAll() {
		return companyDao.findAll();

	}

	@Override
	public Company findById(String orgId, String companyId) {
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId,companyId);
		Optional<Company> companyOp = companyDao.findById(orgCompanyId);
//		if (companyOp.isPresent()) {
//			Company com = companyOp.get();
//			return com;
//			return companyOp.get();
//		}
		return companyOp.orElse(new Company());
	}
	public Company updateById(String orgId, String companyId) {  //Jpa不提供update語法，需先找資料再Save
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId,companyId);
		Optional<Company> companyOp = companyDao.findById(orgCompanyId);
		//updateName
		if (companyOp.isPresent()) {
			Company com = companyOp.get();
			com.setCompanyName("A01");
			Company newCom = companyDao.save(com);
			return newCom;
		}
		return new Company();
	}
	
	public Company saveCompany() {
		Company com = new Company("AAA","BBB","CCC");
		return companyDao.save(com);
	}


}

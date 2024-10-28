package com.pharmassist.service;

import org.springframework.stereotype.Service;

import com.pharmassist.entity.Admin;
import com.pharmassist.repository.AdminRepository;

@Service
public class AdminService {

	private AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}


	
	

}

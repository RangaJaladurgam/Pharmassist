package com.pharmassist.service;

import org.springframework.stereotype.Service;

import com.pharmassist.entity.Admin;
import com.pharmassist.mapper.AdminMapper;
import com.pharmassist.repository.AdminRepository;
import com.pharmassist.responsedto.AdminResponse;

@Service
public class AdminService {

	private AdminRepository adminRepository;
	private AdminMapper adminMapper;

	public AdminService(AdminRepository adminRepository,AdminMapper adminMapper) {
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}

	
	public AdminResponse findAdmin(String adminId) {
		
		return adminRepository.findById(adminId)
						.map((admin)->adminMapper.mapToAdminResponse(admin))
						.orElseThrow(null);
		
	}

	
	
	

}

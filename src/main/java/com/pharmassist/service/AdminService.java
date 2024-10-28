package com.pharmassist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pharmassist.entity.Admin;
import com.pharmassist.mapper.AdminMapper;
import com.pharmassist.repository.AdminRepository;
import com.pharmassist.requestdto.AdminRequest;
import com.pharmassist.responsedto.AdminResponse;

@Service
public class AdminService {

	private AdminRepository adminRepository;
	private AdminMapper adminMapper;

	public AdminService(AdminRepository adminRepository,AdminMapper adminMapper) {
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}

	
	public AdminResponse saveAdmin(AdminRequest adminRequest) {
		Admin admin = adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));
		return adminMapper.mapToAdminResponse(admin);
	}
	
	public AdminResponse findAdmin(String adminId) {
		
		return adminRepository.findById(adminId)
						.map((admin)->adminMapper.mapToAdminResponse(admin))
						.orElseThrow(null);
		
	}


	public AdminResponse updateAdmin(String adminId, AdminRequest adminRequest) {
		
	   return adminRepository.findById(adminId)
	   					.map((exAdmin)->{
	   						adminMapper.mapToAdmin(adminRequest, exAdmin);
	   						return adminRepository.save(exAdmin);
	   					})
	   					.map(adminMapper::mapToAdminResponse)
	   					.orElseThrow(null);
	   					
	}


	public List<AdminResponse> findAllAdmins() {
		return adminRepository.findAll()
						.stream()
						.map(adminMapper::mapToAdminResponse)
						.toList();
															
	}


	

	

	

	
	
	

}

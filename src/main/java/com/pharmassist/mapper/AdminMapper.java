package com.pharmassist.mapper;

import com.pharmassist.entity.Admin;
import com.pharmassist.requestdto.AdminRequest;
import com.pharmassist.responsedto.AdminResponse;

public class AdminMapper {
	
	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin) {
		admin.setEmail(adminRequest.getEmail());
		admin.setPassword(adminRequest.getPassword());
		admin.setPhoneNumber(adminRequest.getPhoneNumber());
		return admin;
	}
	
	public AdminResponse mapToAminResponse(Admin admin) {
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.setAdminId(admin.getAdminId());
		adminResponse.setEmail(admin.getEmail());
		return adminResponse;
	}
}

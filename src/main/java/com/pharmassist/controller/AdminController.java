package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.pharmassist.entity.Admin;
import com.pharmassist.responsedto.AdminResponse;
import com.pharmassist.service.AdminService;
import com.pharmassist.util.AppResponseBuilder;
import com.pharmassist.util.ResponseStructure;

@Controller
public class AdminController {
	
	private final AdminService adminService;
	private final AppResponseBuilder response;

	public AdminController(AdminService adminService,AppResponseBuilder response) {
		this.adminService = adminService;
		this.response = response;
	}
	
	
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminId){
		AdminResponse admin = adminService.findUser(adminId);
		return response.success(HttpStatus.FOUND,"Admin found by Id", admin);
	}
	
}

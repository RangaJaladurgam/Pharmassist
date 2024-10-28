package com.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(@PathVariable String adminId){
		AdminResponse admin = adminService.findAdmin(adminId);
		return response.success(HttpStatus.FOUND,"Admin found by Id", admin);
	}
	
}

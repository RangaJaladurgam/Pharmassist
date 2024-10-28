package com.pharmassist.controller;

import org.springframework.stereotype.Controller;

import com.pharmassist.service.AdminService;

@Controller
public class AdminController {
	
	private final AdminService adminService;

	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	
	
}

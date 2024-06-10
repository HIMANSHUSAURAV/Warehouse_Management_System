package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.AdminService;
import com.jsp.warehouse.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/api/version1")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody  @Valid AdminRequest adminRequest){
		return adminService.saveAdmin(adminRequest);
	}
	
	@PostMapping("/warehouses/{warehouseId}/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@RequestBody @Valid AdminRequest adminRequest, @PathVariable int warehouseId){
		return adminService.createAdmin(adminRequest, warehouseId);
	}
}
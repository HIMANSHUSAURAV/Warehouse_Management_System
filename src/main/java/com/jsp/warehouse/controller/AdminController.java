package com.jsp.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.AdminService;
import com.jsp.warehouse.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody  @Valid AdminRequest adminRequest){
		return adminService.saveAdmin(adminRequest);
	}
	
	@PreAuthorize("hasAuthority('CREATE_ADMIN')")
	@PostMapping("/warehouses/{warehouseId}/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@RequestBody @Valid AdminRequest adminRequest, @PathVariable int warehouseId){
		return adminService.createAdmin(adminRequest, warehouseId);
	}
	
	 @PutMapping("/admins")
	    public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody @Valid AdminRequest adminRequest, int adminId) {
		 return adminService.updateAdmin(adminRequest, adminId);
	 }
	 
	 @PreAuthorize("hasAuthority('CREATE_ADMIN')")
	 @PutMapping("/admins/{adminId}")
	    public ResponseEntity<ResponseStructure<AdminResponse>> updateSuperByAdmin(@RequestBody @Valid AdminRequest adminRequest, @PathVariable int adminId) {
		 return adminService.updateSuperByAdmin(adminRequest, adminId);
	 }
	 
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdminById( @PathVariable int adminById){
		 return adminService.findAdminById( adminById);
	}
	
	 
		@GetMapping("/admins")
		public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins(){
			
			 return adminService.findAllAdmins();
		}
		
		
	
}





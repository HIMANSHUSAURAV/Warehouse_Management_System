package com.jsp.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(AdminRequest adminRequest);
	
	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@RequestBody AdminRequest adminRequest, int warehouseId);
	
	ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin( AdminRequest adminRequest, int adminId);
	
	ResponseEntity<ResponseStructure<AdminResponse>> updateSuperByAdmin(@Valid AdminRequest adminRequest, int adminId);
	
	ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminById);
	
	ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins();
	




}

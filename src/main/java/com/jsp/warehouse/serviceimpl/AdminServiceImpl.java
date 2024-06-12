package com.jsp.warehouse.serviceimpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.enums.AdminType;
import com.jsp.warehouse.enums.Privilege;
import com.jsp.warehouse.exception.AdminNotFoundByEmailException;
import com.jsp.warehouse.exception.AdminNotFoundByIdException;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.exception.WarehouseNotFoundByIdException;
import com.jsp.warehouse.mapper.AdminMapper;
import com.jsp.warehouse.repo.AdminRepo;
import com.jsp.warehouse.repo.WarehouseRepo;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.requestdto.WarehouseRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.AdminService;
import com.jsp.warehouse.utility.ResponseStructure;


import jakarta.validation.Valid;
@Service
public class AdminServiceImpl implements  AdminService{

	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private AdminMapper adminMapper; 

	@Autowired
	private WarehouseRepo warehouseRepo;


	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(AdminRequest adminRequest) {
		if(adminRepo.existsByAdminType(AdminType.SUPER_ADMIN)) {
			throw new IllegalOperationException("Illegal Operation to add a Supre Admin");
		}

		Admin admin = adminMapper.mapToAdmin(adminRequest,new Admin());
		admin.setAdminType(AdminType.SUPER_ADMIN);
		admin = adminRepo.save(admin);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<AdminResponse>()
						.setData(adminMapper.mapToAdminResponse(admin))
						.setMessage("Super_Admin Saved Successfully")
						.setStatus(HttpStatus.CREATED.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest, int warehouseId) {

		return warehouseRepo.findById(warehouseId).map(warehouse-> {

			Admin   admin = adminMapper.mapToAdmin(adminRequest, new Admin()); 
			admin.setAdminType(AdminType.Admin); 
			admin=adminRepo.save(admin); 

			warehouse.setAdmin(admin);
			warehouseRepo.save(warehouse);

			return ResponseEntity.status(HttpStatus.CREATED) 
					.body( new ResponseStructure<AdminResponse>() 
							.setStatus(HttpStatus.CREATED.value()) 
							.setMessage("Admin added") 
							.setData(adminMapper.mapToAdminResponse(admin)));

		}).orElseThrow(()->
		new WarehouseNotFoundByIdException("warehouse with given id not present"));

	}


	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@Valid AdminRequest adminRequest, int adminId) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return adminRepo.findByAdminEmail(email).map(exAdmin -> {

			Admin  admin =adminRepo.save(exAdmin);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<AdminResponse>()
							.setStatus(HttpStatus.OK.value())
							.setMessage("admin updated")
							.setData(adminMapper.mapToAdminResponse(exAdmin)));
		}).orElseThrow(() -> new AdminNotFoundByEmailException("failed to updated admin"));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateSuperByAdmin(@Valid AdminRequest adminRequest,
			int adminId) {
		return adminRepo.findById(adminId).map(existingAdmin -> {
			existingAdmin = adminMapper.mapToAdmin(adminRequest, existingAdmin);
			existingAdmin = adminRepo.save(existingAdmin);


			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<AdminResponse>()
							.setStatus(HttpStatus.OK.value())
							.setMessage("Admin updated successfully")
							.setData(adminMapper.mapToAdminResponse(existingAdmin)));
		}).orElseThrow(() -> new AdminNotFoundByIdException("no admin find by given id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminById) {

		return adminRepo.findById(adminById).map(admin -> ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<AdminResponse>()
						.setStatus(HttpStatus.FOUND.value())
						.setMessage("Admin found")
						.setData(adminMapper.mapToAdminResponse(admin)))
				).orElseThrow(() ->new AdminNotFoundByEmailException("Admin not found"));

	}

	@Override
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins() {
		List<AdminResponse> adminsList = adminRepo.findAll().stream().map(admin -> 
		adminMapper.mapToAdminResponse(admin)).toList();

		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<AdminResponse>>()
						.setStatus(HttpStatus.FOUND.value())
						.setMessage("Admins Found")
						.setData(adminsList));
	}

}









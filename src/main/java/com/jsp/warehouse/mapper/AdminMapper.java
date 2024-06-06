package com.jsp.warehouse.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
@Component
public class AdminMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin) {
		return Admin.builder()
				.adminName(adminRequest.getAdminName())
				.adminEmail(adminRequest.getAdminEmail())
				.password(passwordEncoder.encode(adminRequest.getPassword()))
				.build();
	}
	public AdminResponse mapToAdminResponse(Admin admin) {
		return AdminResponse.builder()
				.adminId(admin.getAdminId())
				.adminName(admin.getAdminName())
				.adminEmail(admin.getAdminEmail())
				.adminType(admin.getAdminType())
				.build();
	}
}




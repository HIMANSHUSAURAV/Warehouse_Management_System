package com.jsp.warehouse.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.enums.AdminType;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public boolean existsByAdminType(AdminType superAdmin);
	
	Optional<Admin> findByAdminEmail(String username);
}

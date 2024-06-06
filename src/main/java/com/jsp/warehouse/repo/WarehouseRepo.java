package com.jsp.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Admin;

public interface WarehouseRepo extends JpaRepository<Admin, Integer> {

}

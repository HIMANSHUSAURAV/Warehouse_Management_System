package com.jsp.warehouse.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.warehouse.entity.Warehouse;

public interface WarehouseRepo extends JpaRepository<Warehouse, Integer> {


}
